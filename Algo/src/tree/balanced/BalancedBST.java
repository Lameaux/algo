package tree.balanced;

/**
 * Balanced BST. Can be used as key->value storage. 
 * @author sergii.sizov
 *
 * @param <K> key type
 * @param <V> value type
 */
public interface BalancedBST<K extends Comparable<K>, V> {

	/**
	 * Checks if tree is empty
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Number of elements in the tree
	 * @return
	 */
	int size();

	/**
	 * Return elements as sorted array
	 * @return
	 */
	Object[] toArray();

	/**
	 * Puts key with value
	 * @param key
	 * @param value
	 * @return previous value or null
	 */
	V put(K key, V value);
	
	/**
	 * Gets value by key
	 * @param key
	 * @return value or null
	 */
	V get(K key);	

	/**
	 * Removes key from the tree
	 * @param key
	 * @return true if key existed
	 */
	boolean delete(K key);
	
	/**
	 * Checks if key exists in tree
	 * @param key
	 * @return
	 */
	boolean contains(K key);
	
	/**
	 * Calculates the height of the tree
	 * @return
	 */
	int height();
	
	/**
	 * Calculates balance factor of the tree
	 * @return
	 */
	int balance();

}
