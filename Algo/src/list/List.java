package list;


public interface List<T> {

	void add(T value);

	boolean remove(T value);

	void clear();

	boolean contains(T value);

	void reverse();

	Object[] toArray();

	int size();

	boolean isEmpty();
	
	T get(int index);
	
	T set(int index, T value);
	
	int indexOf(T value);

}
