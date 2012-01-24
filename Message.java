//message object, implements Serialization interface to allow the current state to be written to IO streams
public class Message implements Serialization {
	//client who sent message
	String username;
	
	//message body
	String message;
	
	//flag set if is administrative call
	boolean isApiCall;
	
	//Client messages
	public Message(String message, String username, boolean isAdminCall) {
		//create the string fields
		this.message = message;
		this.username = username;
		
		//set the boolean flag if the message is an administrative call
		isAdminCall = (message.substring(0,2).equals("./")) ? true : false;
	}
	
	//Server messages only
	public Message(String message) {
		username = "Server";
		this.message = message;
		isApiCall = true;
	}
	
}