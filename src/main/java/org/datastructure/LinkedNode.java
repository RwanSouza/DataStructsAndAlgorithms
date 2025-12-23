package org.datastructure;

import java.util.Objects;

public class LinkedNode {

	private int data;
	private LinkedNode next;
	
	public LinkedNode(int data, LinkedNode next) {
		this.data = data;
		this.next = next;
	}
	
	
	public int data() {
		return this.data;
	} 
	
	public LinkedNode next() {
		return this.next;
	}
	
	public boolean hasNext() {
		return Objects.nonNull(this.next);
	}
	
	public void append(LinkedNode node) {
		this.next  = node;
	}
}
