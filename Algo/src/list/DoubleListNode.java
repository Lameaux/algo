package list;

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
