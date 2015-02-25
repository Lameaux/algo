package list;


public interface List {

	void add(Object value);

	boolean remove(Object value);

	void clear();

	boolean contains(Object value);

	void reverse();

	Object[] toArray();

	int size();

	boolean isEmpty();
	
	Object get(int index);
	
	Object set(int index, Object value);
	
	int indexOf(Object value);

}
