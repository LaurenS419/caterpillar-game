package assignment2;
import java.util.NoSuchElementException;

public class MyStack<E> {

    private MyDoublyLinkedList<E> stack;

    public MyStack(){
        stack = new MyDoublyLinkedList<E>();
    }

    public void push(E element){
        stack.addFirst(element);
    }

    public E pop(){
        if(stack.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.removeFirst();
    }

    public E peek(){
        if(stack.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.peekFirst();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void clear(){
        if(stack.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        stack.clear();
    }

    public int getSize(){
        return stack.getSize();
    }

}
