package org.datastructure;

import java.text.MessageFormat;
import java.util.Objects;

public class DoubleLinkedList {
	
	private DoubleLinkedNode head;
	private DoubleLinkedNode tail;
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void insertToBack(int data) {
		
		if(Objects.isNull(head)) {
			this.head = new DoubleLinkedNode(data, null, null);
			return;
		}
		
		if(Objects.isNull(this.tail)) {
			this.head.append(new DoubleLinkedNode(data, null, null));
			this.tail = this.head.next();
			return;
		}
		
		this.tail.append(new DoubleLinkedNode(data, null, null));
		this.tail = this.tail.next();
	}
	
	public void insertToFront(int data) {

		if (Objects.isNull(head)) {
			this.head = new DoubleLinkedNode(data, null, null);
			this.tail = this.head;
			return;
		}

		if (Objects.nonNull(this.head)) {
			this.head.prepend(new DoubleLinkedNode(data, null, null));
			this.head = this.head.prev();
		}
	}
	
	public Integer getHead() {
		return Objects.nonNull(head) ? head.data() : null;
	}
	
	public Integer getTail() {
		return Objects.nonNull(tail) ? tail.data() : null;
	}
	
	public int[] traverse() {
		DoubleLinkedNode current = this.head; 
		DynamicArray array = new DynamicArray();
		while(current != null) {
			
			array.insert(current.data());
			current = current.next();
		}
		
		return array.getArrayCopy();
	}
	
	public void delete(int target) {
		
		if(Objects.nonNull(head) && getHead() == target) {
			this.head = this.head.next();
			this.head.prepend(null);
			return;
		}
		
		if(Objects.nonNull(this.tail) && getTail() == target) {
			
			this.tail = this.tail.prev();
			this.tail.next().prepend(null);
			this.tail.append(null);
			return;
		}
		
		DoubleLinkedNode current = Objects.nonNull(head) ? this.head.next() : null;
		while(current != null) {
			
			if(current.data() == target) {
				current.prev().append(current.next());
				return;
			}
			current = current.next();
		}
		
		throw new RuntimeException(MessageFormat.format("No element with value {0} was found in the list", target));
	}
	
	public Integer search(int target) {
		
		if(Objects.nonNull(head) && getHead() == target) 
			return this.head.data();
		
		if(Objects.nonNull(tail) && getHead() == target) 
			return this.tail.data();
		
		DoubleLinkedNode current = this.head;
		while (Objects.nonNull(current)) {
			if (current.data() == target)
				return current.data();

			current = current.next();
		}

		throw new RuntimeException(MessageFormat.format("No element with value {0} was found in the list", target));
	}
}
