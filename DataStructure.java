public class DataStructure <E> implements List<E>{
    //custom linked list to hold objects
    
    //head node
    Node head;
    
    //
    public DataStructure() {}
    
    //add to the data structure, encapsulate in a node
    public void add(E obj , int index) {
        //create a new node
        Node temp = new Node(obj, index);
        
        //add to the top of the list
        temp.setNext(head);
        
        //make the new node the head node
        head = temp;
    }
    
    //remove from datastructure
    public E remove(int index) {
        //remove obj E and dereference Node
        Node current = head;
        while(current.getNext().getIndex() != index) {
            //keep searching
        }
        
    }
    
    public class Node <E> {
        E obj;
        int index;
        
        Node next;
        
        //private methods to abstract to DataStructure only
        private Node(E obj, int index) {
            
        }
        
        private void setNext(Node next) {
            this.next = next;
        }
        
        private 
        
        private int getIndex() {
            return index;
        }
        
    }
}
