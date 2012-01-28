
import java.util.ArrayList;

public interface ConnectionManagerAPI {
	
	//creates a new room, returns true on success
	public boolean createNewRoom(String roomName);
	
	//removes a client from existing room, adds to new room. first checks if room exists
	public boolean addClientToRoom(Client client);
	
	public void addClientToDefaultLobby(Client client);
	
	//returns a list of all rooms available on the server
	public <String>ArrayList getListOfRooms();
	
	//returns the number of connected users in a specific room
	public int getNumberOfClientsInRoom();
	
	//returns the number of clients currently connected to the whole server
	public int getNumberOfClients();
	
	//checks to see if a room exists
	public boolean doesRoomExit();
	
}