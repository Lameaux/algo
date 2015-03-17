package tree;

/**
 * Binary Search Tree
 * 
 * @author sergii.sizov
 * 
 * @param <T>
 *            element type
 */
public interface BST<T extends Comparable<T>> {

	/**
	 * Check if tree is empty
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Number of elements in the tree
	 * 
	 * @return
	 */
	int size();

	/**
	 * Get elements as array
	 * 
	 * @return
	 */
	Object[] toArray();

	/**
	 * Add new element to the tree
	 * 
	 * @param value
	 * @return true if value was not already in the tree
	 */
	boolean add(T value);

	/**
	 * Delete element from the tree
	 * 
	 * @param value
	 * @return true if value was in the tree
	 */
	boolean delete(T value);

	/**
	 * Check if element exists in the tree
	 * 
	 * @param value
	 * @return
	 */
	boolean contains(T value);

	/**
	 * Calculate the height of the tree
	 * 
	 * @return
	 */
	int height();

}
