package org.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class PriorityQueue {

	private List<Integer> elements;
	private Function<Integer, Integer> priority;

	public PriorityQueue(List<Integer> elements, Function<Integer, Integer> elementPriority) {

		this.priority = elementPriority;
		if (Objects.nonNull(elements) && !elements.isEmpty()) {
			heapFi(elements);
			return;
		}
		
		this.elements = new ArrayList<>();
	}

	private boolean isEmpty() {
		return this.elements.isEmpty(); 
	}
	
	public int len() {
		return this.elements.size();
	}

	private boolean hasLowerPriority(int elementOne, int elementTwo) {
		return this.priority.apply(elementOne) < this.priority.apply(elementTwo);
	}
	
	private boolean hasHigherPriority(int elementOne, int elementTwo) {
		return this.priority.apply(elementOne) > this.priority.apply(elementTwo);
	}
	
	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}
	
	private int parentIndex(int index) {
		return (index - 1) / 2;
	}
	
	private int firstLeafIndex() {
		return len() / 2;
	}
	
	public int peek() {
		return elements.get(0);
	}
	
	private int  highestPriorityChildIndex(int index) {
		int firstIndex =  this.leftChildIndex(index);
		
		if(firstIndex >=  len())
			return -1;
		
		if(firstIndex  + 1 >= len())
			return firstIndex;
		
		if(hasHigherPriority(elements.get(firstIndex), elements.get(firstIndex +1)))
			return firstIndex;
		
		return firstIndex + 1;
	}
	
	private void bubbleUp(int index) {
		
		assert index >= 0 && index < this.elements.size();
		
		int element = this.elements.get(index);
		while(index > 0) {
			
			int indexParent = this.parentIndex(index);
			int parent = this.elements.get(indexParent);
			if(hasHigherPriority(element, parent)) {
				this.elements.set(index, parent);
				index = indexParent;
			}else {
				break;
			}
		}
		
		this.elements.set(index, element);
		
	}
	
	public void insert(int element) {
		elements.add(element);
		bubbleUp(len() - 1);
		
		System.out.println();
	}
	
	private void pushDown(int index) {
		Integer element = null;
		
		element = elements.get(index);
		int currentIndex = index;
		
		while(true) {
			int childIndex = this.highestPriorityChildIndex(currentIndex);
			
			if(childIndex <= -1)
				break;
			
			if(hasLowerPriority(element, elements.get(childIndex))) {
				this.elements.set(currentIndex, elements.get(childIndex));
				currentIndex = childIndex;
			}
			
			else 
				break;
		}
		
		elements.set(currentIndex, element);
	}
	
	public  Integer top() {
		Integer element = null;
		if(isEmpty()) 
			throw new RuntimeException("Method top called on an empty heap.");
		
		if(len() == 1) {
			return elements.remove(0);
		}
		
		element = elements.get(0);
		elements.set(0, elements.remove(elements.size() - 1));
		this.pushDown(0);
		
		return element;
	}
	
	private void heapFi(List<Integer> elements) {
		
		this.elements = new ArrayList<>(elements);
		int lastInnerNodeIndex = this.firstLeafIndex() -1;
		
		for (int index = lastInnerNodeIndex; index >= 0; index--) {
		    pushDown(index);
		}
	}
}	
