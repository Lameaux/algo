package stack;

import java.util.EmptyStackException;

import arrays.Arrays;

public class ArrayStack<E> implements Stack<E> {

	private static final int INITIAL_STACK_SIZE = 32;
	private static final int ARRAY_GROW_RATIO = 2;

	private E[] array;
	int size = 0;

	public ArrayStack() {
		this(INITIAL_STACK_SIZE);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		array = (E[]) new Object[initialCapacity];
	}

	private void ensureCapacity(int capacity) {
		if (capacity > array.length) {
			E[] newArray = Arrays.enlargeAndCopy(array, array.length * ARRAY_GROW_RATIO);
			// GC
			java.util.Arrays.fill(array, 0, array.length-1, null);			
			array = newArray;
		}
	}

	@Override
	public E push(E value) {
		ensureCapacity(size + 1);
		array[size++] = value;
		return value;
	}

	@Override
	public E pop() {
		E value = peek();
		// GC
		array[size - 1] = null;
		size--;
		return value;

	}

	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return array[size - 1];
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
