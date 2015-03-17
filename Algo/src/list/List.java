package list;

/**
 * List data structure
 * 
 * @author sergii.sizov
 * 
 * @param <T>
 *            element type
 */
public interface List<T> {

	/**
	 * Add new element to the list
	 * 
	 * @param value
	 */
	void add(T value);

	/**
	 * Remove element from the list
	 * 
	 * @param value
	 * @return true if element was in the list
	 */
	boolean remove(T value);

	/**
	 * Remove all elements
	 */
	void clear();

	/**
	 * Check if element is in the list
	 * 
	 * @param value
	 * @return true if element exists in the list
	 */
	boolean contains(T value);

	/**
	 * Reverse elements order
	 */
	void reverse();

	/**
	 * Get elements as array
	 * 
	 * @return
	 */
	Object[] toArray();

	/**
	 * Get number of elements
	 * 
	 * @return
	 */
	int size();

	/**
	 * Check if list is empty
	 * 
	 * @return true if empty
	 */
	boolean isEmpty();

	/**
	 * Get element by index
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 *             if index < 0 or index > count-1
	 */
	T get(int index) throws IndexOutOfBoundsException;

	/**
	 * Set element at index
	 * 
	 * @param index
	 * @param value
	 * @return previous element at index
	 * @throws IndexOutOfBoundsException
	 *             if index < 0 or index > count-1
	 */
	T set(int index, T value) throws IndexOutOfBoundsException;

	/**
	 * Get index of the first occurrence of the value
	 * 
	 * @param value
	 * @return index
	 */
	int indexOf(T value);

}
