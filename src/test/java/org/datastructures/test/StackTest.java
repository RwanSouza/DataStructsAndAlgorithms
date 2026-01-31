package org.datastructures.test;

import org.datastructure.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

	private Stack stack;

	@BeforeEach
	public void createStack() {
		this.stack = new Stack();
	}

	@Test
	@DisplayName("Should push elements to stack")
	void shouldPushElementsToStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.peek());
	}

	@Test
	@DisplayName("Should pop and return elements from stack")
	void shouldPopElementsFromStack() {
		stack.push(1);
		stack.push(2);
		stack.push(3);

		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
	}

	@Test
	@DisplayName("Should return top element without removing it using peek")
	void shouldPeekTopElementWithoutRemoving() {
		stack.push(10);
		stack.push(20);

		assertEquals(20, stack.peek());
		assertEquals(20, stack.peek());
		assertEquals(20, stack.pop());
	}

	@Test
	@DisplayName("Should follow LIFO order (Last In First Out)")
	void shouldFollowLIFOOrder() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		assertEquals(4, stack.pop());
		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
	}

	@Test
	@DisplayName("Should throw NullPointerException when popping from empty stack")
	void shouldThrowExceptionWhenPopFromEmptyStack() {
		NullPointerException message = assertThrows(NullPointerException.class, () -> {
			stack.pop();
		});
		
		assertEquals("Cannot pop from an empty stack", message.getMessage());
	}

	@Test
	@DisplayName("Should throw NullPointerException when peeking at empty stack")
	void shouldThrowExceptionWhenPeekAtEmptyStack() {
		NullPointerException message = assertThrows(NullPointerException.class, () -> {
			stack.peek();
		});
		
		assertEquals("Cannot peek at an empty stack", message.getMessage());
	}

	@Test
	@DisplayName("Should throw NullPointerException after popping all elements")
	void shouldThrowExceptionAfterPoppingAllElements() {
		stack.push(1);
		stack.push(2);

		stack.pop();
		stack.pop();

		assertThrows(NullPointerException.class, () -> {
			stack.pop();
		});
	}

	@Test
	@DisplayName("Should handle a single element correctly")
	void shouldHandleSingleElement() {
		stack.push(42);

		assertEquals(42, stack.peek());
		assertEquals(42, stack.pop());

		assertThrows(NullPointerException.class, () -> {
			stack.peek();
		});
	}

	@Test
	@DisplayName("Should handle push after pop operations")
	void shouldHandlePushAfterPop() {
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);

		assertEquals(3, stack.peek());
		assertEquals(3, stack.pop());
		assertEquals(1, stack.pop());
	}
}
