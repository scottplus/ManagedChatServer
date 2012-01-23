//methods available to the client, separated for client-level abstraction
public interface ClientMethods {
	
	//broadcasts to all Client objects in the room
	public void broadcastMessage(Message latestMessage);
	
	//obtain the room name
	public String getRoomName();
	
	
}