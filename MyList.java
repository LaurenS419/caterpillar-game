package assignment2;

public interface MyList<E> extends Iterable<E> {

    public int getSize(); //returns size of list
    public boolean isEmpty(); //returns if list is empty
    public void add(E element); //adds element to end of list
    public void clear(); //makes list empty
    public E remove(); //removes specified element

}
