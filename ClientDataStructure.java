public class ClientDataStructure <Client> extends DataStructure {
    
    public ClientDataStructure() {
        super();
    }
    
    public void send(Message message) {
        //traverse the list, sending the message
        Node current = head;
        while(current.getNext() != null) {
            Client client = (Client) current.getNext().getObj();
            client.write(message);
        }
    }
}
