package org.datastructure;

import java.text.MessageFormat;
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

		if (Objects.isNull(current)) {
			this.head = new LinkedNode(data, null);
			this.tail = this.head;
		} else {
			while (current.hasNext())
				current = current.next();

			LinkedNode node = new LinkedNode(data, null);
			current.append(node);
			this.tail = node;
		}
	}

	public Integer search(int data) {
		LinkedNode current = this.head;

		while (Objects.nonNull(current)) {
			if (current.data() == data)
				return current.data();

			current = current.next();
		}

		return null;
	}

	public void insertInFront(int data) {
		LinkedNode oldHead = this.head;
		this.head = new LinkedNode(data, oldHead);
	}

	public void delete(int target) {
		LinkedNode current = this.head;
		LinkedNode previous = this.tail;

		while (Objects.nonNull(current)) {
			if (current.data() == target) {
				if (Objects.isNull(previous))
					this.head = current.next();
				else
					previous.append(current.next());
				return;
			}
			previous = current;
			current = current.next();
		}

		throw new RuntimeException(MessageFormat.format("No element with value {0} was found in the list", target));

	}
	
	public Integer  deleteFromFront() {
		LinkedNode current = this.head;
		
		if(Objects.nonNull(current)) {
			int data = this.head.data();
			this.head = current.next();
			return data;
		} 
		
		throw new RuntimeException("No value  was found in the list");
	}

	public Integer tail() {
		return Objects.nonNull(tail) ? tail.data() : null;
	}

	public Integer head() {
		return Objects.nonNull(head) ? head.data() : null;
	}
}
