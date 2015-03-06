package stack;

public class ArrayStack<E> implements Stack<E> {

	private static final int INITIAL_STACK_SIZE = 32;
	private static final int ARRAY_GROW_RATIO = 2;

	private E[] array;
	int index = -1;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		array = (E[]) new Object[INITIAL_STACK_SIZE];
	}

	private void ensureCapacity(int capacity) {
		if (capacity > array.length) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[array.length * ARRAY_GROW_RATIO];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
	}

	@Override
	public E push(E value) {
		ensureCapacity(index + 1);
		index++;
		array[index] = value;
		return value;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean empty() {
		return index == -1;
	}

}
