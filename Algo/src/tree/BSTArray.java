package tree;

import objects.Objects;

/**
 * Implementation of BST using array
 * @author sergii.sizov
 *
 * @param <T>
 */
public class BSTArray<T extends Comparable<T>> implements BST<T> {

	private T[] array;
	private int count;
	
	@SuppressWarnings("unchecked")
	public BSTArray(int treeHeight) {
		int arrayLength = (int)Math.pow(2, treeHeight) - 1; // 2**height - 1
		array = (T[])new Comparable[arrayLength];
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[count];
		
		rToArray(0, result, 0);
		
		return result;
	}

	private int rToArray(int index, Object[] result, int offset) {
		if (array[index] == null) {
			return offset;
		}

		int leftIndex = left(index);
		if (valid(leftIndex)) {
			offset = rToArray(leftIndex, result, offset);
		}

		result[offset] = array[index];
		offset++;

		int rightIndex = right(index);
		if (valid(rightIndex)) {
			offset = rToArray(rightIndex, result, offset);
		}

		return offset;

	}
	
	private int left(int index) {
		return 2 * index + 1;
	}

	private int right(int index) {
		return 2 * index + 2;
	}
	
	
	@Override
	public void add(T value) {
		// first
		if (array[0] == null) {
			array[0] = value;
			count++;
			return;
		}
		
		int current = 0;
		while (current < array.length) {
			if (Objects.less(value, array[current])) { // check left
				int leftIndex = left(current);
				if (array[leftIndex] == null) {
					array[leftIndex] = value;
					count++;
					return;
				} else {
					current = leftIndex;
				}
			} else { // check right
				int rightIndex = right(current);
				if (array[rightIndex] == null) {
					array[rightIndex] = value;
					count++;
					return;
				} else {
					current = rightIndex;
				}
			}
		}
		
		throw new ArrayIndexOutOfBoundsException("Backing array is too small for this tree");
		
	}

	private boolean valid(int index) {
		return (index < array.length && array[index] != null);
	}
	
	@Override
	public boolean contains(T value) {
		if (isEmpty()) {
			return false;
		}

		// first
		if (Objects.equals(array[0], value)) {
			return true;
		}
		
		int current = 0;
		while (current < array.length) {
			if (Objects.less(value, array[current])) { // check left
				int leftIndex = left(current);
				if (!valid(leftIndex)) {
					return false;
				}
				if (Objects.equals(value, array[leftIndex])) {
					return true;
				} else {
					current = leftIndex;
				}
			} else { // check right
				int rightIndex = right(current);
				if (!valid(rightIndex)) {
					return false;
				}				
				if (Objects.equals(value, array[rightIndex])) {
					return true;
				} else {
					current = rightIndex;
				}
			}
		}		
		
		return false;
		
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

}
