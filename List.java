public interface List<E> {
    
    //add to the datastruct
    public void add(E obj);
    
    //remove from the datastructure where index == index
    public E remove(int index);
    
    //return the object where index == index
    public E get(int index);
    
    //returns the index of the object to synchronise
    public int getCurrentIndex();
    
    //returns the size of the structure
    public int size();
}