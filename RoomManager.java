
import java.util.ArrayList;

public class RoomManager extends Thread {
	//connection manager reference
	ConnectionManagerAPI manager;
	
	//datastructure
	ArrayList<Room> rooms;
	
	public RoomManager(ConnectionManagerAPI manager) {
		this.manager = manager;
	}
	
	//threading
	public void run() {
		//start the RoomManager
	}
	
//*** METHODS ACCESSABLE BY CONNECTION MANAGER
	public boolean doesRoomExistAtThisLevel(String room) {
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
	
//*** API METHODS ACCESSABLE BY ROOM OBJECTS

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
			
		}
        }
	
	
	public boolean doesRoomExist(String room) {
		//forward to the connection manager
		return manager.doesRoomExist(room);
	}
}