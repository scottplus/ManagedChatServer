public class ConnectionManager extends Thread implements ConnectionManagerAPI {
	ServerSocket host;
	<RoomManager>ArrayList managers;
	
	
	//parameters IP, Port, backlog
	public ConnectionManager(InetAddress ipAddress, int port, int backlog) {
		//incomming clients
		host = new ServerSocket(ipAddress, backlog, port); // ** ADD PARAMETERS
		
		//RoomManager arraylist
		managers = new ArrayList<RoomManager>();
		
		//add new room manager object, and add the default lobby room
	}
	
//*** PARENT CLASS METHODS ***	
	public boolean stopServer() {}
	
	
//*** INTERFACE METHODS ***
	
	public boolean createNewRoom(String roomName) {}
	
	public void addClientToDefaultLobby(Client client) {
		managers.get(0).add;
	}
	
	public boolean addClientToRoom(String roomName, Client client, Room currentRoom) {}
	
	public <String>ArrayList getListOfRooms() {}
	
	public int getNumberOfClientsInRoom() {}
	
	public int getNumberOfClients() {}
	
	public boolean doesRoomExist(String room) {
		//loop through the room manager objects to check room names
		for(RoomManager current : managers) {
			if(current.doesRoomExistAtThisLevel(room)) {
				return true;
			}
		}
	}
	
}