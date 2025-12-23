package org.datastructure;

import java.util.Objects;

public class SinglyLinkedList {
	
	private LinkedNode head;
	private LinkedNode tail;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertToBack(int data) {
		LinkedNode current = this.head;
		
		if(Objects.isNull(current)) {
			this.head = new LinkedNode(data, null);
			this.tail = this.head;
		}
		else {
			while(current.hasNext()) 
				current = current.next();
			
			LinkedNode node = new LinkedNode(data, null);
			current.append(node);
			this.tail = node;
		}		
	}
	
	public void insertInFront(int data) {
		LinkedNode oldHead = this.head;
		this.head = new LinkedNode(data, oldHead); 
	}
	
	public Integer tail() {
		return Objects.nonNull(tail)? tail.data(): null;
	}
	
	public Integer head() {
		return Objects.nonNull(head)? head.data(): null;
	}
}
