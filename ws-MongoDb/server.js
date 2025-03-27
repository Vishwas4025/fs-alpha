const mongoose = require('mongoose');
const WebSocket = require('ws');

mongoose.connect("mongodb://127.0.0.1:27017/").then(() => console.log("Connected to mongoDB"))

const employeeSchema = new mongoose.Schema({
    name : String, 
    salary : Number,
    role : String,
    department: String,
    experience: Number
});

const empModel = mongoose.model('employees' , employeeSchema);

let idCounter = 1;

const server = new WebSocket.Server({port : 8080});


server.on("connection" , (socket) => {
    console.log("Client Connected");

    socket.on("message" , async (event) => {
        const parts = event.toString().split(" ");
        const command = parts[0];
        console.log(parts);

        if(command === "INSERT" && parts.length === 6){
            const name = parts[1];
            const salary = parseInt(parts[2]);
            const role = parts[3];
            const department = parts[4];
            const experience = parseInt(parts[5]);

            const response = await empModel.create({id : idCounter++ , name , salary , role , department , experience});

            socket.send("Employee inserted successfully.");
        } else if(command === "RETRIEVE"){
            const response = await empModel.find({} , {_id : 0 , __v : 0});
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years` ).join('\n');
            idCounter = 1;
            socket.send(data);
        } else if(command === "RETRIEVE_BY_DEPT" && parts.length === 2){
            const dept = parts[1];
            const response = await empModel.find({department: dept} , { _id: 0 , __v: 0});
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years` ).join('\n');
            idCounter = 1;
            socket.send(data);
            console.log(data);
        } else {
            socket.send("Invalid Command");
        }
    })
})