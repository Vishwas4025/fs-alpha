const WebSocket = require("ws");

const server = new WebSocket.Server({ port: 8080 });

let clients = [];

server.on("connection", (socket) => {

    clients.push(socket);
    console.log("New client connected");

    socket.on("message", (message) => {
        console.log("message received:", message.toString());
        for(const client of clients){
            if(client.readyState === WebSocket.OPEN){
                client.send(message.toString());
            }
        }
    });

    socket.on("close", () => {
        clients = clients.filter((client) => client !== socket);
        console.log("Client disconnected");
    });
});

console.log("WebSocket server running on ws://192.168.5.57:8080");

