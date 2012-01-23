public interface RoomMethods {
	
	//adds the client to the room, parameter of Client object
	public void addClientToRoom(Client current);
	
	//removes the client from the room and returns a Client object
	public Client removeClientFromRoom();
	
	//used for searching rooms
	public String getRoomName();
}