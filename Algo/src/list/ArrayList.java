package list;

import objects.Objects;
import arrays.Arrays;

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_SIZE = 32;
	private static final int ARRAY_GROW_RATIO = 2;

	private T[] array;
	private int count = 0;

	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		array = (T[])new Object[size];
	}

	private void ensureCapacity(int capacity) {
		if (capacity > array.length) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[])new Object[array.length * ARRAY_GROW_RATIO];
			System.arraycopy(array, 0, newArray, 0, array.length);
			// GC
			java.util.Arrays.fill(array, 0, array.length-1, null);			
			array = newArray;
		}
	}

	public void trimToSize() {
		if (count < array.length) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[])new Object[count];
			System.arraycopy(array, 0, newArray, 0, count);
			array = newArray;
		}
	}

	@Override
	public void add(T value) {
		ensureCapacity(count + 1);
		array[count] = value;
		count++;
	}

	@Override
	public boolean remove(T value) {
		if (isEmpty()) {
			return false;
		}

		for (int i = 0; i < count; i++) {
			// found
			if (Objects.equals(array[i], value)) {

				// not the last element
				if (i < count - 1) {
					System.arraycopy(array, i + 1, array, i, count - i - 1);
				}
				// GC
				array[count-1] = null;
				count--;
				
				return true;
			}
		}

		return false;
	}

	@Override
	public void clear() {
		// GC
		java.util.Arrays.fill(array, 0, count - 1, null);
		count = 0;

	}

	@Override
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	@Override
	public void reverse() {
		Object[] dataArray = toArray();
		Arrays.reverse(dataArray);
		System.arraycopy(dataArray, 0, array, 0, count);

	}

	@Override
	public Object[] toArray() {
		Object[] copy = new Object[count];
		System.arraycopy(array, 0, copy, 0, count);
		return copy;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public T get(int index) {

		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		return array[index];
	}

	@Override
	public int indexOf(T value) {
		if (isEmpty()) {
			return -1;
		}

		for (int i = 0; i < count; i++) {
			if (Objects.equals(array[i], value)) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public T set(int index, T value) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		T old = array[index];
		array[index] = value;
		return old;
	}

}
