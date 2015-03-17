package tree.balanced;

public interface BalancedBST<K extends Comparable<K>, V> {

	boolean isEmpty();

	int size();

	Object[] toArray();

	/**
	 * Puts key with value
	 * @param key
	 * @param value
	 * @return previous value
	 */
	V put(K key, V value);
	
	/**
	 * Gets value by key
	 * @param key
	 * @return value
	 */
	V get(K key);	

	boolean delete(K key);
	boolean contains(K key);
	
	int height();
	
	int balance();

}
