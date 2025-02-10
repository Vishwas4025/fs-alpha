const express = require("express");
// const bodyParser = require("body-parser");
// const cors = require("cors");

const app = express();
const PORT = 3000;

app.use(express.json());
// app.use(bodyParser.json());
// app.use(cors());

let orders = [
    { id: 1,  customerName: "Azar", totalPrice: 150.0 }
];


app.post("/orders",(req,res)=>{
    const {customerName, totalPrice} = req.body;
    const order = {
        id : orders.length+1,
        customerName,
        totalPrice
    }
    orders.push(order);
    res.json(order);
})

app.get("/orders",(req,res)=>{
    res.json(orders);
})

app.get("/orders/:id",(req,res)=>{
    const id = parseInt(req.params.id);
    const order = orders.find(o => o.id===id);
    if(!order){
        res.status(404).json({message: "order not found"});
    }
    res.json(order);
})

app.put("/orders/:id",(req,res)=>{
    const id = parseInt(req.params.id);
    const {customerName, totalPrice} = req.body;
    
    const order = orders.find(o => o.id===id);
    if(!order){
        res.status(404).json({message:"order not found"});
    }
    order.customerName = customerName;
    order.totalPrice = totalPrice;
    res.json(order);
})

app.delete("/orders/:id",(req,res)=>{
    const id = parseInt(req.params.id);
    orders = orders.filter(o => o.id!==id);
    res.json({message: "order deleted"});
})


app.listen(PORT, ()=>{
    console.log(`server running on ${PORT}`);
})