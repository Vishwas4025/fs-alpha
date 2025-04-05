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
            idCounter = 1;
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years` ).join('\n');
            socket.send(data);
        } else if(command === "RETRIEVE_BY_DEPT" && parts.length === 2){
            const dept = parts[1];
            const response = await empModel.find({department: dept} , { _id: 0 , __v: 0});
            idCounter = 1;
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years` ).join('\n');
            socket.send(data);
            console.log(data);
        } else {
            socket.send("Invalid Command");
        }
    })
})









// const ws = require("ws");
// const mongoose = require("mongoose");
// const server = new ws.Server({ port: 8080 });

// mongoose.connect("mongodb://127.0.0.1:27017/")
//     .then(() => {
//         console.log("Connected to MongoDB");
//     })
//     .catch(() => {
//         console.log("Error connecting to MongoDB");
//     });

// const employeeSchema = new mongoose.Schema({
//     name: String,
//     salary: Number,
//     role: String,
//     department: String,
//     experience: Number
// });

// const Employee = mongoose.model("employee", employeeSchema);

// server.on("connection", (socket) => {
//     console.log("Client connected");
    
//     socket.on("message", async (message) => {
//         console.log(`Received message: ${message}`);
//         const parts = message.toString().trim().split(/\s+/);
        
//         if (parts[0] === "INSERT" && parts.length === 6) {
//             const name = parts[1].trim();
//             const salary = parseFloat(parts[2].trim());
//             const role = parts[3].trim();
//             const department = parts[4].trim();
//             const experience = parseInt(parts[5].trim());
            
//             if (!name || isNaN(salary) || !role || !department || isNaN(experience)) {
//                 socket.send("Invalid input");
//                 return;
//             }
            
//             const newEmployee = new Employee({ name, salary, role, department, experience });
//             await newEmployee.save();
//             socket.send("Inserted successfully");
//         } 
//         else if (parts[0] === "RETRIEVE") {
//             const employees = await Employee.find();
            
//             if (employees.length === 0) {
//                 socket.send("No employees found");
//             } else {
//                 const employeeList = employees.map((emp, index) =>
//                     `ID: ${index + 1}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
//                 ).join("\n");
//                 socket.send(employeeList);
//             }
//         } 
//         else if (parts[0] === "RETRIEVE_BY_DEPT" && parts.length === 2) {
//             const department = parts[1].trim();
//             const employees = await Employee.find({ department });
            
//             if (employees.length === 0) {
//                 socket.send("No employees found in department: " + department);
//             } else {
//                 const employeeList = employees.map((emp, index) =>
//                     `ID: ${index + 1}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
//                 ).join("\n");
//                 socket.send(employeeList);
//             }
//         } 
//         else {
//             socket.send("Invalid command");
//         }
//     });
    
//     socket.on("close", () => {
//         console.log("Client disconnected");
//     });
// });

// console.log("WebSocket server is running on ws://192.168.5.60:8080");