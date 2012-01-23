public class Message {
	//message body
	String message;
	
	//client who sent message
	String username;
	
	//flag set if is administrative call
	boolean isAdminCall;
	
	public Message(String message, String username, boolean isAdminCall) {
		//create the string fields
		this.message = message;
		this.username = username;
		
		//set the boolean flag if the message is an administrative call
		isAdminCall = (message.substring(0,2).equals("./")) ? true : false;
	}
	
}