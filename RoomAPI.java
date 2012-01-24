public Interface RoomAPI {
	
	//forwards to the RM
	public void createNewRoom(String roomName);
	
	//adds the client to the specified room
	public void addClientToRoom(String roomName, int clientID);
	
	//changes the client's username and notifies all connected clients (checks if duplicate username exists)
	public void changeUsername(String newUsername, int clientID);
	
	//send message to all clients
	public synchronized void broadcast(Message message);
	
	//send message to specific clientID
	public synchronized void broadcast(Message message, int clientID);
	
	//removes the client from the server
	//public quit();
	
}