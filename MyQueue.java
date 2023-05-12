package assignment2;
import java.util.NoSuchElementException;

public class MyQueue<E>{

    private MyDoublyLinkedList<E> queue;

    public MyQueue(){
        queue = new MyDoublyLinkedList<E>();
    }

    public void enqueue(E element){
        queue.addLast(element);
    }

    public E dequeue(){
        if(queue.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return (E) queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void clear(){
        queue.clear();
    }

    @Override
    public boolean equals(Object obj) {
        return this.queue.equals(((MyQueue) obj).queue);

    }

}
