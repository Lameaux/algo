package queue;

public interface Queue<E> {

	boolean offer(E value);

	E pop();

	E peek();

	boolean empty();
	
	int size();

}
