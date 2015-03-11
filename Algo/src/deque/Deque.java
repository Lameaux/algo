package deque;

public interface Deque<E> {

	boolean offerFirst(E value);

	E popFirst();

	E peekFirst();

	boolean offerLast(E value);

	E popLast();

	E peekLast();	
	
	boolean empty();
	
	int size();	
	
}
