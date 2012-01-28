public interface RoomAPI {
	
	//forwards to the RM
	public void createNewRoom(String roomName);
	
	//adds the client to the specified room
	public void addClientToRoom(String roomName, Client client);
	
	//changes the client's username and notifies all connected clients (checks if duplicate username exists)
	public void changeUsername(String newUsername, Client client);
	
	//send message to all clients
	public void broadcast(Message message);
	
	//send message to specific clientID
	public void broadcast(Message message, int clientID);
	
	//removes the client from the server
	//public quit();
	
}