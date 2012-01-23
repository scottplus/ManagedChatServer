//Room class, holds all clients that are assigned to its room; Operations are add, remove, change room

public class Room implements RoomMethods, ClientMethods {
	
	LinkedList clients;
	String roomName;
	
	public Room(String roomName) {
		//create a new datastructure (empty)
		clients = new LinkedList();
		
		//update the room name
		this.roomName = roomName;
	}
	
	//adds client to datastructure
	public void addClientToRoom(Client client) {
		//set the callback methods for the client to use
		clients.setCurrentRoom(this);
		
		//add the client to the datastructure
		clients.add(client);
	}
	
	//removes client from datastructure
	public Client removeClientFromRoom(Client clientToRemove) {
		//remove at index, unique
		return clients.remove(clientToRemove);
	}
	
	//we need to have one critical section over the linkedlist
	public synchronized void broadcastMessage(Message message) {
		//traverse the list and broadcast to all clients
	}
	
	//returns room name used for searching
	public String getRoomName() {
		return roomName;
	}
	
	
}
