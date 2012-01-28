
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
	//current room object (default lobby)
	RoomManagerAPI currentRoom;
	
	//socket
	Socket connection;
	
	//input stream
	ObjectInputStream input;
	
	//username
	String username;
	
	//unique id
	int clientID;
	
	public Client(int clientID, Socket connection) throws IOException {
		//init objects
		this.clientID = clientID;
		this.connection = connection;
		input = new ObjectInputStream(connection.getInputStream());
	}

	public void listen() {
       	//listen for blocking IO
			
                
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
	
	public void setUsername(String username) {
		
	}
}