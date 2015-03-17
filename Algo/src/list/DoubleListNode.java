package list;

/**
 * Node of the double-linked list, contains value and pointers to previous and
 * next nodes.
 * 
 * @author sergii.sizov
 * 
 * @param <T>
 *            element type
 */
public class DoubleListNode<T> {

	public DoubleListNode<T> next;
	public DoubleListNode<T> previous;
	public T value;

	public DoubleListNode() {

	}

	public DoubleListNode(T value) {
		this.value = value;
	}

}
