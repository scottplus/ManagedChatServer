public class RoomManager {
	//connection manager reference
	ConnectionManagerAPI manager;
	
	//datastructure
	<Room>ArrayList rooms;
	
	public RoomManager(ConnectionManagerAPI manager) {
		this.manager = manager;
	}
	
	public boolean addClientToRoom(String roomName, Client client, Room currentRoom) {
		if(doesRoomExistAtCurrentLevel(room)) {
			//room is in the current RoomManager object
			
			//notify users that user is leaving room
			currentRoom.broadcast(new Message(client.username + " has left the room!"));
			
			//remove client from current room
			client = currentRoom.remove(client);
			
			//add client to new room where rooms.get() == room
			for(Room current : rooms) {
				//if we are at the right room, add the user
				if(current.room.equals(roomName)) {
					//add the client to the room and notify the room
					current.room.broadcast(new Message(client.username + "has entered the room!"));
					current.room.addClient(client);
					break;
				}
			}
			
		} else if(manager.addClientToRoom(roomName, client, currentRoom)) {
			//the room is in another RoomManager object
						
			
		} else {
			//the room does not exist
			return false;
		}
	}
	
	private boolean doesRoomExistAtCurrentLevel(String room) {
		//search ArrayList
	}
	
	public boolean doesRoomExist(String room) {
		
	}
}