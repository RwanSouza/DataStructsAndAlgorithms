package org.datastructure;

import java.text.MessageFormat;
import java.util.Arrays;

public class DynamicArray {

	private int   maxCapacity = 1;
	private int   size    = 0;
	private int[] dynamicArray;
	
	public DynamicArray() {
		this.dynamicArray = new int[maxCapacity];
	}
	
	private void doubleCapacity() {
		
		int[] oldArray = this.dynamicArray;
		this.maxCapacity = this.maxCapacity * 2;
		this.dynamicArray = new int[maxCapacity];
		
		copyArray(oldArray, this.dynamicArray);
	}
	
	public void insert(int value) {
		
		if(size >= maxCapacity ) 
			this.doubleCapacity();
		
		this.dynamicArray[size] = value;
		size++;
	}
	
	public int find(int value) {
		
		for(int i = 0; i < size; i++ ) {
			if(dynamicArray[i] == value) 
				return i;
		}
		
		return -1;
	}
	
	public void delete(int value) {
		int index = find(value);
		
		if(index < 0) 
			throw new IllegalArgumentException(MessageFormat.format("Unable to delete element {0}: the entry "
					+ "is not in the array", value));
		
		for(int i = index; i < size; i++) 
			dynamicArray[i] = dynamicArray[i + 1];
	
		size--;
		
		if(size > 1 &&  size <= maxCapacity / 4) {
			halveSize();
		}
	}
	
	public int[] getArrayCopy() {
		return Arrays.copyOf(this.dynamicArray, size);
	}

	public int getSize() {
		return size;
	}

	public int capacity() {
		return maxCapacity;
	}
	
	public void halveSize () {
		this.maxCapacity = this.maxCapacity / 2;
		
		int[] oldArray = this.dynamicArray;
		this.dynamicArray = new int[maxCapacity];
		
		copyArray(oldArray, this.dynamicArray);
	}
	
	private void copyArray(int[] from , int[] to) {
		for(int i= 0; i < size; i++) 
			to[i] = from[i];
	}
}
