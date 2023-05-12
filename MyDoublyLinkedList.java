package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;

	// from MyList ----
	public void add(E element){
		this.addLast(element);
	}

	public void clear(){
		while(!this.isEmpty()){
			this.removeFirst();
		}
	}

	public E remove(){
		return this.removeLast();
	}
	// ----

	public void addFirst(E element){
		DNode newNode = new DNode();
		newNode.element = element;

		if(head == null){
			head = newNode;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}

		this.size = this.getSize() + 1;
	}

	public void addLast(E element){
		DNode newNode = new DNode();
		newNode.element = element;

		if(head == null){
			head = newNode;
			tail = head;
			head.next = null;
			tail.prev = null;
		}

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		tail.next = null;

		this.size = this.getSize() + 1;
	}

	public E removeFirst(){
		if(this.isEmpty() || this.head == null){
			throw new NoSuchElementException("List is empty");
		}

		DNode temp = this.head;
		this.head = this.head.next;

		if(this.head != null){
			this.head.prev = null;
		}

		this.size = this.getSize() - 1;
		return temp.element;
	}

	public E removeLast(){
		if(this.isEmpty()){
			throw new NoSuchElementException("List is empty");
		}

		if(this.head != null && this.head.next == null){
			DNode temp = this.head;
			this.head = null;

			this.size = this.getSize() - 1;
			return temp.element;
		}

		if(this.tail == null){

			DNode curNode = this.head;
			for(int i = 0; i < this.getSize() - 1; i++){
				curNode = curNode.next;
			}
			DNode temp = curNode;
			curNode = null;
			this.size = this.getSize() - 1;
			return temp.element;
		}

		DNode temp = this.tail;
		this.tail = this.tail.prev;
		this.tail.next = null;


		this.size = this.getSize() - 1;
		return temp.element;

	}

	public E peekFirst(){
		if(this.getSize() == 0){
			throw new NoSuchElementException("List is empty");
		}
		if(this.head == null){
			return this.head.next.element;
		}

		return this.head.element;
	}

	public E peekLast(){
		if(this.getSize() == 0){
			throw new NoSuchElementException("List is empty");
		}
		if(this.tail == null){
			return this.head.element;
		}

		return this.tail.element;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MyDoublyLinkedList)){
			//System.out.println("not instanceof DLL");
			return false;
		}

		if(this.getSize() != ((MyDoublyLinkedList<?>) obj).getSize()){
			//System.out.println("not same size");
			return false;
		}

		if(this.getSize()==0 && ((MyDoublyLinkedList<?>) obj).getSize()==0){
			//System.out.println("both size 0");
			return true;
		}

		DNode curNode = this.head;
		for(E objEl : (MyDoublyLinkedList<E>) obj){
			if(!objEl.equals(curNode.element)){
				return false;
			}
			curNode = curNode.next;
		}
		return true;

		/*
		DNode curNode = this.head;
		MyDoublyLinkedList<E> objs = (MyDoublyLinkedList<E>) obj;
		for(int i = 0; i < this.getSize(); i++){

			if(curNode.element.equals(objs.removeFirst())){ //destroys obj?
				//System.out.println(curNode.element);
				curNode = curNode.next;
			}
			else{
				return false;
			}
		}
		return true;

		 */

	}

	// end of my code
	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
