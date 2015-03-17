package deque;

import java.util.NoSuchElementException;

/**
 * Deque - double-ended queue
 * 
 * @author sergii.sizov
 * 
 * @param <E>
 *            element type
 */
public interface Deque<E> {

	/**
	 * Add element to the beginning
	 * 
	 * @param value
	 * @return true if operation was successful, otherwise false
	 */
	boolean offerFirst(E value);

	/**
	 * Return and remove element from the beginning
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if deque is empty
	 */
	E popFirst() throws NoSuchElementException;

	/**
	 * Return element from the beginning
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	E peekFirst() throws NoSuchElementException;

	/**
	 * Add element to the end
	 * 
	 * @param value
	 * @return true if operation was successful, otherwise false
	 */
	boolean offerLast(E value);

	/**
	 * Return and remove element from the end
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if deque is empty
	 */
	E popLast();

	/**
	 * Return element from the end
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	E peekLast();

	/**
	 * Check if deque is empty
	 * 
	 * @return
	 */
	boolean empty();

	/**
	 * Number of elements in deque
	 * 
	 * @return
	 */
	int size();

}
