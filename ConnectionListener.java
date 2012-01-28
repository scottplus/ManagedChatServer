public class ConnectionListener extends Thread {
	ServerSocket connection;
	boolean serverIsRunning = false;
	
	public ConnectionListener(int port, ConnectionManagerAPI connectionManager) {
		this.port = port;
		connection = new ServerSocket(port);		
	}
	
	public void run() {
		serverIsRunning = true;
		runServer();
	}
	
	public void runServer() {
		while(serverIsRunning) {
			//listen for clients, create new objects and pass to the connection manager
			
			//increment the unique ID
			clientID++;
			
			new Client(this.clientID, connection.accept());
		}
	}
	
	public boolean serverSwitch(boolean status) {
		//BOOLEAN TRUE == RUN SERVER BOOLEAN FALSE == CLOSE SERVER
		serverIsRunning = status;
		if(status && connection.isClosed()) {
			//start a new connection
			connection = new ServerSocket(this.port);
			runServer();
		} else if(!status && !connection.isClosed()) {
			//close the connection
			connection.close();
		}
		
		//return the server state
		return connection.close();
	}
	
}