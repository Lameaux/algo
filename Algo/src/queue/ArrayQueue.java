package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

	private static final int INITIAL_QUEUE_SIZE = 32;
	private static final int ARRAY_GROW_RATIO = 2;

	private E[] array;
	private int head = 0;
	private int tail = -1;
	private int size = 0;

	public ArrayQueue() {
		this(INITIAL_QUEUE_SIZE);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity) {
		array = (E[]) new Object[initialCapacity];
	}

	private void ensureCapacity(int capacity) {
		if (capacity > array.length) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[size * ARRAY_GROW_RATIO];

			// copy values to new array
			int j=0;
			for (int i=head; i<=tail;i++) {
				newArray[j++] = array[i % array.length];
			}

			// GC
			java.util.Arrays.fill(array, 0, array.length-1, null);

			// recalculate head and tail
			tail = tail - head;
			head = 0;
			
			array = newArray;
		}
	}

	@Override
	public boolean offer(E value) {
		ensureCapacity(size + 1);
		size++;
		tail++;
		array[tail % array.length] = value;
		return true;
	}

	@Override
	public E pop() {
		E value = peek();
		array[head % array.length] = null;
		head++;
		size--;
		return value;
	}

	@Override
	public E peek() {
		if (empty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return array[head % array.length];
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
