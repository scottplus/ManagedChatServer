public interface List<E> {
    
    //add to the datastruct
    public void add(E obj, int index);
    
    //remove from the datastructure where index == index
    public E remove(int index);
}