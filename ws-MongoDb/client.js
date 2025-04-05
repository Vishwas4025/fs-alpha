const ws = require('ws');
const socket = new ws('ws://localhost:8080');
socket.on('open', () => {
    console.log('Connected to server');
    socket.send('INSERT Alice 50000 Developer IT 5');
    socket.send('INSERT Bob 60000 Manager IT 5');
    socket.send('RETRIEVE');
    socket.send('RETRIEVE_BY_DEPT IT');
    socket.send("Invalid command.")
});
socket.on('message', (message) => {
    console.log(`Server response: ${message}`);
});
socket.on('close', () => {
    console.log('Disconnected from server');
});