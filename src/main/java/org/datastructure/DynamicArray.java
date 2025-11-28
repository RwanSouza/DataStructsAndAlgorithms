package org.datastructure;

import java.util.Arrays;

public class DynamicArray {

	private int   dynamicCapacity = 1;
	private int   size    = 0;
	private int[] dynamicArray;
	
	public DynamicArray() {
		this.dynamicArray = new int[dynamicCapacity];
	}
	
	private void doubleCapacity() {
		int[] oldArray = this.dynamicArray;
		this.dynamicCapacity = this.dynamicCapacity * 2;
		this.dynamicArray = new int[dynamicCapacity];
		
		for(int i= 0; i < size; i++) 
			this.dynamicArray[i] = oldArray[i];
	}
	
	public void insert(int value) {
		
		if(size >= dynamicCapacity ) 
			this.doubleCapacity();
		
		this.dynamicArray[size] = value;
		size++;
	}
	
	public int[] getArrayCopy() {
		return Arrays.copyOf(this.dynamicArray, size);
	}

	public int getSize() {
		return size;
	}

	public int getDynamicCapacity() {
		return dynamicCapacity;
	}
}
