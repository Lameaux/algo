package list;

/**
 * Node of the list, contains value and pointer to the next element
 * 
 * @author sergii.sizov
 * 
 * @param <T>
 *            element type
 */
public class ListNode<T> {

	public ListNode<T> next;
	public T value;

	public ListNode() {

	}

	public ListNode(T value) {
		this.value = value;
	}

}
