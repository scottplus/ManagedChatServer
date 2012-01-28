import java.util.LinkedList;

//Room class, holds all clients that are assigned to its room; Operations are add, remove, change room

public class Room implements RoomAPI {

        //clients currently in room
	RoomManagerAPI manager; 								//RoomManager for API calls
	String room;											//unique room name
	
	//construct the object
	public Room(String room, RoomManagerAPI manager) {
		this.room = room;
		this.manager = manager;
		list = new LinkedList<Client>();
	}
	
//*** PRIVATE METHODS
	
	
//*** METHODS ACCESSIBLE TO ROOM MANAGER

	//remove client from room, return object
	public Client removeClient(Client client) {
		//traverse the linked list, remove where
                
                
	}
	
	//add client to room
	public void addClient(Client client) {
		//add to the arraylist
		clientList.add(client);
	}
	
	public boolean equals(String room) {
		return this.room.equals(room);
	}
	
	
//*** METHODS ACCESSIBLE TO CLIENTS
	
	//create new room on the server
	public void createNewRoom(String room, Client client) {
		//forward to the RoomManager
		if( manager.createNewRoom(room) ) {
			//room creation success
			broadcast(new Message("The room " + room + " was successfully created", "Server", false));
		} else {
			//room creation failure
			broadcast(new Message("The room " + room + " could not be created, please try again later", "Server", false), client));
		}
	}
	
	//adds the client to the specified room
	public void addClientToRoom(String room, Client client) {
		if(this.room != room) {
			//forward to the RoomManager
			if(!manager.addClientToRoom(room, client, this()) ) {
				//room does not exist, notify client
				broadcast(new Message("The room does not exist, please create it to enter"), client);
			}
			
		} else {
			//notify client that they are already in the room
			broadcast(new Message("You are already in the room: "+room, "Server", false), client);
		}
	}
	
	//changes the client's username and notifies all connected clients (checks if duplicate username exists)
	public void changeUsername(String newUsername) {}
	
	//broadcast message object to all clients
	public synchronized void broadcast(Message message) {
		for(Client current : clientList) {
			//write to all clients
			current.output.write(message);
			current.output.flush();
		}
	}
	
	//broadcast message object to specific clientID
	public synchronized void broadcast(Message message, Client client) {
		//send to the specific client
		client.output.write(message);
		client.output.flush();
	}

    @Override
    public void createNewRoom(String roomName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changeUsername(String newUsername, Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void broadcast(Message message, int clientID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}
