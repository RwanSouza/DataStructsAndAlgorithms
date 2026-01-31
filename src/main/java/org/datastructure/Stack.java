package org.datastructure;

public class Stack {

	private SinglyLinkedList container;
	
	public Stack() {
		this.container = new SinglyLinkedList();
	} 
	
	public void push(int value) {
		container.insertInFront(value);
	}
	
	public int pop() {
		
		if(container.isEmpty()) 
			throw new NullPointerException("Cannot pop from an empty stack");
		
		return container.deleteFromFront();
	}
	
	public int peek() {
		if(container.isEmpty()) 
			throw new NullPointerException("Cannot peek at an empty stack");
		
		return container.get(0);
	}
}
