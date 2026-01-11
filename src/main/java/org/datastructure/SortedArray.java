package org.datastructure;

import java.util.Arrays;

public class SortedArray {

	private int   maxSize = 1000;
	private int   size = 0;
	private int[] sortedArray;
	private int lastExecutionSteps = 0;
	
	public  SortedArray() {
		this.sortedArray = new int[maxSize];
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void insert(int value) {
		
		if(this.size >= maxSize) throw new RuntimeException("The array is already full, maximum size");	
		
		for(int i = size; i > 0; i--) {
			if(sortedArray[i-1] <= value) {
				sortedArray[i] = value;
				size++;
				return;
			}
			sortedArray[i] = sortedArray[i-1];
			
		}
		sortedArray[0] = value;
		size++;
	}
	
	public int[] getArrayCopy() {
		return Arrays.copyOf(this.sortedArray, this.sortedArray.length);
	}
	
	public int search(int target) {
		
		for(int i =0; i < size; i++) {
			
			if(sortedArray[i] == target) {
				return i;
			} else if(sortedArray[i] > target) {
				return -1;
			}
		}
		
		return -1;
	}
	
	
	public int  delete(int index) {
		
		if(index == -1 || index > maxSize) throw new RuntimeException("Unable to delete element " + index +": the "
				+ "entry is not in the array"); 
		
		int valueDeleted = sortedArray[index];
		for(int i =  index; i < size -1 ; i++) {
			sortedArray[i] =  sortedArray[i + 1];
		}
		sortedArray[size -1] = 0;
		size--;
		return valueDeleted;
	} 
	
	public int binarySearch(int target) {
		this.lastExecutionSteps = 0;
		int left = 0;
		int right = size -1;
		
		while(left <= right) { 
			lastExecutionSteps++;
			int mid = (left + right) / 2;
			int midValue = sortedArray[mid];
			
			if(target == midValue) 
				return mid;
			else if(midValue >  target) 
				right = mid - 1;
			else  
				left = mid + 1;
		}
		
		return -1;
	}
	
	public  int getSteps() {
		return lastExecutionSteps;
	}
}
