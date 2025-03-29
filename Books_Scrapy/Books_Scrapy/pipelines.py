# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
# from itemadapter import ItemAdapter


# class BooksScrapyPipeline:
#     def process_item(self, item, spider):
#         return item



import pymongo
from scrapy.utils.project import get_project_settings

class MongoPipeline:
    def __init__(self):
        settings = get_project_settings()
        self.mongo_uri = settings.get("MONGO_URI")
        self.mongo_db = settings.get("MONGO_DB")
        self.collection_name = settings.get("MONGO_COLLECTION", "books")

    def open_spider(self, spider):
        self.client = pymongo.MongoClient(self.mongo_uri)
        self.db = self.client[self.mongo_db]

    def close_spider(self, spider):
        self.client.close()

    def process_item(self, item, spider):
        self.db[self.collection_name].insert_one(dict(item))
        return item
