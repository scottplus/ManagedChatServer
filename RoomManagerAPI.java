public Interface RoomManagerAPI {
	//forwards the call to the connection manager returns true on cascade success
	public boolean createNewRoom();
	
	//add the specified client to the room
	public boolean addClientToRoom(String room, Client client, Room currentRoom);
	
	//checks to see if the room exists in the current room manager object true if room exists
	public boolean doesRoomExist(String room);
}