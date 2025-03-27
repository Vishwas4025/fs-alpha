// const WebSocket = require("ws");
// const mongoose = require("mongoose");

// mongoose
//   .connect("mongodb+srv://vishwasracharla09:vishwasracharla09@cluster0.7nfmvrv.mongodb.net/EmployeeDB?retryWrites=true&w=majority&appName=Cluster0", {
//     useNewUrlParser: true,
//     useUnifiedTopology: true,
//   })
//   .then(() => console.log("Connected to MongoDB"))
//   .catch((err) => console.error("MongoDB connection error:", err));

// // Task Schema and Model
// const employeeSchema = new mongoose.Schema({
//     name: String,
//     salary: Number,
//     role: String,
//     department: String,
//     experience: Number
// });

// const Employee = mongoose.model("employees", employeeSchema);



// const server = new WebSocket.Server({ port: 8080 });


// function insertEmployee(socket, name, salary) {
//     const salaryNum = parseFloat(salary);
    
// }

// function retrieveEmployees(socket) {
    
// }

// let clients = [];

// server.on("connection", (socket) => {
//     clients.push(socket);
//     console.log("New client connected");

//     socket.on("message", (message) => {
//         console.log(`Received: ${message}`);
//         const parts = message.toString().split(" ");

//         if (parts[0] === "INSERT" && parts.length === 3) {
//             insertEmployee(socket, parts[1], parts[2]);
//         } else if (parts[0] === "RETRIEVE") {
//             retrieveEmployees(socket);
//         } else {
//             socket.send("Invalid command.");
//         }
//     });

//     socket.on("close", () => {
//         clients = clients.filter((client) => client !== socket);
//         console.log("Client disconnected");
//     });
// });

// console.log("WebSocket server running on ws://localhost:8080");



// const WebSocket = require("ws");
// const mongoose = require("mongoose");

// // Connect to MongoDB
// mongoose
//   .connect("mongodb://127.0.0.1:27017/", {
//     useNewUrlParser: true,
//     useUnifiedTopology: true,
//   })
//   .then(() => console.log("Connected to MongoDB"))
//   .catch((err) => console.error("MongoDB connection error:", err));

// // Employee Schema & Model
// const employeeSchema = new mongoose.Schema({
//   name: String,
//   salary: Number,
//   role: String,
//   department: String,
//   experience: Number
// });

// const Employee = mongoose.model("Employee", employeeSchema);

// // Start WebSocket Server
// const server = new WebSocket.Server({ port: 8080 });

// let clients = [];

// server.on("connection", (socket) => {
//   clients.push(socket);
//   console.log("New client connected");
//   socket.send("Connected");

//   socket.on("message", async (message) => {
//     console.log(`Received: ${message}`);
//     const parts = message.toString().split(" ");

//     if (parts[0] === "INSERT" && parts.length === 6) {
//       insertEmployee(socket, parts[1], parts[2], parts[3], parts[4], parts[5]);
//     } else if (parts[0] === "RETRIEVE") {
//       retrieveEmployees(socket);
//     } else if (parts[0] === "RETRIEVE_BY_DEPT" && parts.length === 2) {
//       retrieveByDepartment(socket, parts[1]);
//     } else {
//       socket.send("Invalid command.");
//     }
//   });

//   socket.on("close", () => {
//     clients = clients.filter((client) => client !== socket);
//     console.log("Client disconnected");
//   });
// });

// console.log("WebSocket server running on ws://192.168.5.57:8080");

// // Insert Employee Function
// async function insertEmployee(socket, name, salary, role, department, experience) {
//   const salaryNum = parseFloat(salary);
//   const expNum = parseInt(experience);

//   if (isNaN(salaryNum) || isNaN(expNum)) {
//     socket.send("Invalid salary or experience format.");
//     return;
//   }

//   try {
//     const employee = new Employee({ name, salary: salaryNum, role, department, experience: expNum });
//     await employee.save();
//     socket.send("Employee inserted successfully.");
//   } catch (err) {
//     socket.send("Error inserting employee.");
//   }
// }

// // Retrieve All Employees
// async function retrieveEmployees(socket) {
//   try {
//     const employees = await Employee.find();
//     if (employees.length === 0) {
//       socket.send("No employees found.");
//       return;
//     }

//     const employeeList = employees.map(emp => 
//       `ID: ${emp._id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
//     ).join("\n");

//     socket.send(employeeList);
//   } catch (err) {
//     socket.send("Error retrieving employees.");
//   }
// }

// // Retrieve Employees by Department
// async function retrieveByDepartment(socket, department) {
//   try {
//     const employees = await Employee.find({ department });
//     if (employees.length === 0) {
//       socket.send(`No employees found in ${department} department.`);
//       return;
//     }

//     const employeeList = employees.map(emp => 
//       `ID: ${emp._id}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
//     ).join("\n");

//     socket.send(employeeList);
//   } catch (err) {
//     socket.send("Error retrieving employees by department.");
//   }
// }



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