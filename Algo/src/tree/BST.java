package tree;

public interface BST<T extends Comparable<T>> {

	boolean isEmpty();

	int size();

	Object[] toArray();

	void add(T value);

}
