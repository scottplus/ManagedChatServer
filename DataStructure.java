public class DataStructure <E> implements List<E> {    
    //head node 
    Node head;
    
    //size of the linkedlist, also used for indexes (start from zero)
    int size;
    
    //default constructor
    public DataStructure() {
        size = 0;
    }
    
    //add to the data structure, encapsulate in a node
    public void add(E obj) {
        //increment the size by one
        int index = size;
        
        //increment the size of the datastructure
        size++;
        
        //add the new object to the start of the structure
        
        //create a new node
        Node temp = new Node(obj, index);
        
        //add to the top of the list
        temp.setNext(head.getNext());
        
        //make the head node point to the next node
        head.setNext(temp);
    }
    
    //remove from datastructure
    public E remove(int index) {
        //remove obj E and dereference Node
        E obj = null;
        
        //start from the top of the list
        Node current = head;
        
        //while not at the end of the list
        while(current.getNext() != null) {
            //keep searching
            if(current.getNext().getIndex() == index) {
                //the index matches, remove the object
                obj = (E) current.getNext().getObj();
                
                //remove the next node from the list
                current.setNext(current.getNext().getNext());
                
                size--;
                
                //obj removed and node dereferenced
                return obj;                
            } else {
                //keep searching
                current = current.getNext();
            }
        }
        
        //the index has not been found
        return obj; //*** null pointer, handle for safety on calling code
    }
    
    public int size() {
        return size;
    }
    
    public class Node <E> {
        //object and index in the data structure
        E obj;
        int index;
        
        //reference to the next Node, null if last
        Node next;
        
        //private methods to abstract to DataStructure only
        private Node(E obj, int index) {
            this.obj = obj;
            this.index = index;
        }
        
        private void setNext(Node next) {
            this.next = next;
        }
        
        private Node getNext() {
            return next;
        } 
        
        private int getIndex() {
            return index;
        }
        
        private E getObj() {
            return obj;
        }
    }
}
