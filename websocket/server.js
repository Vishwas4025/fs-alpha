const WebSocket = require("ws");

const server = new WebSocket.Server({ port: 8080 });
const employees = [];
let idCounter = 1;

function insertEmployee(socket, name, salary) {
    const salaryNum = parseFloat(salary);
    if (!isNaN(salaryNum)) {
        employees.push({ id: idCounter++, name, salary: salaryNum });
        socket.send("Employee inserted successfully.");
    } else {
        socket.send("Invalid salary format.");
    }
}

function retrieveEmployees(socket) {
    if (employees.length === 0) {
        socket.send("No employees found.");
    } else {
        const employeeList = employees
            .map(emp => `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`)
            .join("\n");
        socket.send(employeeList);
    }
}

server.on("connection", (socket) => {
    console.log("New client connected");

    socket.on("message", (message) => {
        console.log(`Received: ${message}`);
        const parts = message.toString().split(" ");

        if (parts[0] === "INSERT" && parts.length === 3) {
            insertEmployee(socket, parts[1], parts[2]);
        } else if (parts[0] === "RETRIEVE") {
            retrieveEmployees(socket);
        } else {
            socket.send("Invalid command.");
        }
    });

    socket.on("close", () => {
        console.log("Client disconnected");
    });
});

console.log("WebSocket server running on ws://localhost:8080");
