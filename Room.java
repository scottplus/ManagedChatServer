//Room class, holds all clients that are assigned to its room; Operations are add, remove, change room

public class Room implements RoomAPI {
	<Client>ArrayList clientList;							//clients currently in room
	RoomManagerAPI manager; 								//RoomManager for API calls
	String room;										//unique room name
	
	//construct the object
	public Room(String room, RoomManagerAPI manager) {
		this.room = room;
		this.manager = manager;
		clientList = new ArrayList<Client>();
	}
	
//*** PRIVATE METHODS
	private getUsernameFromID(int clientID) {
		return 
	}
	
	
//*** METHODS ACCESSIBLE TO ROOM MANAGER

	//remove client from room, return object
	public Client removeClient(Client client) {
		return clientList.remove(client);
	}
	
	//add client to room
	public void addClient(Client client) {
		clientList.add(client);
	}
	
	
//*** METHODS ACCESSIBLE TO CLIENTS
	
	//create new room on the server
	public void createNewRoom(String room, int clientID) {
		//forward to the RoomManager
		if( manager.createNewRoom(room) ) {
			//room creation success
			broadcast(new Message("The room " + room + " was successfully created", "Server", false));
		} else {
			//room creation failure
			broadcast(new Message("The room " + room + " could not be created, please try again later", "Server", false), clientID));
		}
	}
	
	//adds the client to the specified room
	public void addClientToRoom(String room, Client client) {
		if(this.room != room) {
			
			//forward to the RoomManager
			if(!manager.addClientToRoom(room, client, this()) ) {
				//room does not exist, notify client
				broadcast(new Message("The room does not exist, please create it to enter"));
			}
			
		} else {
			//notify client
			broadcast(new Message("You are already in the room: "+room, "Server", false), clientID);
		}
	}
	
	//changes the client's username and notifies all connected clients (checks if duplicate username exists)
	public void changeUsername(String newUsername) {}
	
	//broadcast message object to all clients
	public synchronized void broadcast(Message message) {}
	
	//broadcast message object to specific clientID
	public synchronized void broadcast(Message message, int clientID) {
		for(Room current : clientList) {
			//send message
		}
	}
	
}
