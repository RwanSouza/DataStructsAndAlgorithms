package org.datastructure;

public class Queue {

	private int[] data;
	private int maxSize;
	private int front;
	private int rear;
	private int size;

	public Queue(int maxSize) {
		
		if (maxSize <= 1) 
			throw new RuntimeException("Invalid size for a queue (must have at\n"
					+ "least 2 elements): " + maxSize);
		
		this.maxSize = maxSize;
		this.data = new int[maxSize];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	public void enqueue(int data) {
		if(isFull())
			throw new RuntimeException("The queue is already full!");
		
		this.data[rear] = data;
		this.rear = (rear + 1) % this.maxSize;
		this.size++;
	}
	
	public int dequeue() {
		
		if (isEmpty())
			throw new RuntimeException("Cannot dequeue from an empty queue");
		
		int value = data[this.front];
		data[this.front] = 0;
		this.front = (front + 1) % this.maxSize;
		return value;
	}
	
	
	private int len() {
		return this.size;
	} 
	
	public boolean isEmpty() {
		return this.len() == 0;
	}
	
	public boolean isFull () {
		return this.len() == this.maxSize;
	}
}
