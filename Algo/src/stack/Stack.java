package stack;

public interface Stack<E> {

	E push(E value);

	E pop();

	E peek();

	boolean empty();

}
