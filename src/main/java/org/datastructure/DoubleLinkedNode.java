package org.datastructure;

import java.util.Objects;

public class DoubleLinkedNode {

	
	private int data;
	private DoubleLinkedNode next;
	private DoubleLinkedNode prev;
	
	public DoubleLinkedNode(int data, DoubleLinkedNode next, DoubleLinkedNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public int data() {
		return this.data;
	} 
	
	public DoubleLinkedNode next() {
		return this.next;
	}
	
	public DoubleLinkedNode prev() {
		return this.prev;
	}
	
	public boolean hasNext() {
		return Objects.nonNull(this.next);
	}
	
	public boolean has_prev() {
		return Objects.nonNull(prev);
	}
	
	public void append(DoubleLinkedNode node) {
		this.next  = node;
		if(Objects.nonNull(node)) {
			node.prev = this;
		}
	}
	
	public void prepend(DoubleLinkedNode node) {
		this.prev = node;
		if(Objects.nonNull(node)) {
			node.next = this;
		}
	}
}
