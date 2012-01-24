public class Client {
	//current room object (default lobby)
	RoomManagerAPI currentRoom;
	
	//socket
	Socket connection;
	
	//Object IO streams
	ObjectInputStream input;
	ObjectOutputStream output;
	
	//username
	String username;
	
	//unique id
	int clientID;
	
	public Client(int clientID, Socket connection) {
		//init objects
	}

	public void listen() {
		//loop with blocking IO wait for messages
		
		if(message.isApiCall) {
			//API call
		} else {
			//is a message non-auth message, broadcast to all clients
			currentRoom.broadcast(message);
		}
	}
	
	//set the current room
	public void setCurrentRoom(RoomManagerAPI currentRoom) {
		this.currentRoom = currentRoom;
	}
}