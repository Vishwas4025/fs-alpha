const WebSocket = require("ws");

const socket = new WebSocket("ws://localhost:8080");

socket.on("open", () => {
    console.log("Connected to WebSocket server");

    setTimeout(() => socket.send("INSERT Alice 50000"), 1000);
    setTimeout(() => socket.send("INSERT Bob 60000"), 2000);
    setTimeout(() => socket.send("RETRIEVE"), 3000);
    setTimeout(() => socket.send("INVALID"), 4000);
});

socket.on("message", (data) => {
    console.log(`Server Response: ${data}`);
});

socket.on("close", () => {
    console.log("Disconnected from server");
});
