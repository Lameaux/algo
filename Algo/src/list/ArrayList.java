package list;

import objects.Objects;
import arrays.Arrays;

public class ArrayList implements List {

	private static final int DEFAULT_SIZE = 32;
	private static final int ARRAY_GROW_RATIO = 2;

	private Object[] array;
	private int count = 0;

	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	public ArrayList(int size) {
		array = new Object[size];
	}

	private void ensureCapacity(int capacity) {
		if (capacity > array.length) {
			Object[] newArray = new Object[array.length * ARRAY_GROW_RATIO];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
	}

	public void trimToSize() {
		if (count < array.length) {
			Object[] newArray = new Object[count];
			System.arraycopy(array, 0, newArray, 0, count);
			array = newArray;
		}
	}

	@Override
	public void add(Object value) {
		ensureCapacity(count + 1);
		array[count] = value;
		count++;
	}

	@Override
	public boolean remove(Object value) {
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
	public boolean contains(Object value) {
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
	public Object get(int index) {

		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		return array[index];
	}

	@Override
	public int indexOf(Object value) {
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
	public Object set(int index, Object value) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException();
		}

		Object old = array[index];
		array[index] = value;
		return old;
	}

}
