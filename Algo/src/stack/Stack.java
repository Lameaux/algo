package stack;

/**
 * Stack data structure, LIFO
 * 
 * @author sergii.sizov
 * 
 * @param <E>
 *            element type
 */
public interface Stack<E> {

	/**
	 * Add element to the top of the stack and return
	 * 
	 * @param value
	 * @return
	 */
	E push(E value);

	/**
	 * Return and remove element from the top of the stack
	 * 
	 * @return
	 */
	E pop();

	/**
	 * Return element from the top of the stack
	 * 
	 * @return
	 */
	E peek();

	/**
	 * Check if stack is empty
	 * 
	 * @return
	 */
	boolean empty();

	/**
	 * Number of elements in the stack
	 * 
	 * @return
	 */
	int size();

}
