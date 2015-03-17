package queue;

/**
 * Queue data structure, FIFO
 * @author sergii.sizov
 *
 * @param <E> element type
 */
public interface Queue<E> {

	/**
	 * Add element to the end of the queue
	 * @param value
	 * @return true if success, otherwise false (e.g. limited capacity)
	 */
	boolean offer(E value);

	/**
	 * Return and remove element from the beginning
	 * @return
	 */
	E pop();

	/**
	 * Return element from the beginning
	 * @return
	 */
	E peek();

	/**
	 * Check if queue is empty
	 * @return
	 */
	boolean empty();
	
	/**
	 * Number of elements in the queue
	 * @return
	 */
	int size();

}
