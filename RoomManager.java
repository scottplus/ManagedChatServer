public class RoomManager {
	//connection manager reference
	ConnectionManagerAPI manager;
	
	//datastructure
	<Room>ArrayList rooms;
	
	public RoomManager(ConnectionManagerAPI manager) {
		this.manager = manager;
	}
	
//*** METHODS ACCESSABLE BY CONNECTION MANAGER
	public doesRoomExistAtThisLevel(String room) {
		//search this RoomManagers data
		for(Room current : rooms) {
			if(current.room.equals(room)) {
				//room exists
				return true;
			}
		}
		//room doesn't exist
		return false;
	}
	
//*** API METHODS

	public boolean addClientToRoom(String roomName, Client client, Room currentRoom) {
		if(doesRoomExistAtThisLevel(room)) {
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
			
			//room exists
			return true;
			
		} else if(!manager.addClientToRoom(roomName, client, currentRoom)) {
			//the room does not exist
			currentRoom.broadcast(new Message("The room: "+roomName+" does not exist")client);
			
			//room doesn't exit
			return false;
		}
	}
	
	
	public boolean doesRoomExist(String room) {
		//forward to the connection manager
		return manager.doesRoomExist(room);
	}
}