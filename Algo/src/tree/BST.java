package tree;

public interface BST<T extends Comparable<T>> {

	boolean isEmpty();

	int size();

	Object[] toArray();

	boolean add(T value);
	boolean delete(T value);
	
	boolean contains(T value);
	
	int height();

}
