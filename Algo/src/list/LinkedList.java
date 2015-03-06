package list;

import objects.Objects;

public class LinkedList<T> implements List<T> {

	private ListNode<T> head;

	public LinkedList() {

	}

	public LinkedList(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}
	
	@Override
	public void add(T value) {
		ListNode<T> node = new ListNode<T>(value);

		if (isEmpty()) {
			head = node;
			return;
		}

		ListNode<T> last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
	}

	@Override
	public boolean remove(T value) {
		if (isEmpty()) {
			return false;
		}

		ListNode<T> node = head;
		ListNode<T> prev = null;
		do {
			if (Objects.equals(node.value, value)) {
				if (node == head) {
					head = head.next;
				} else {
					prev.next = node.next;
				}
				
				// GC
				node.next = null;
				node.value = null;
				
				return true;
			}
			prev = node;
			node = node.next;
		} while (node != null);

		return false;
	}

	@Override
	public void clear() {
		if (isEmpty()) {
			return;
		}

		ListNode<T> node = head;
		while (node.next != null) {
			ListNode<T> curr = node;
			node = node.next;
			// GC
			curr.next = null;
			curr.value = null;
		}		
		
		head = null;
	}

	@Override
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	@Override
	public void reverse() {
		if (isEmpty()) {
			return;
		}

		ListNode<T> node = head;
		ListNode<T> prev = null;
		while (node != null) {
			// save next reference
			ListNode<T> next = node.next;
			// reverse ref to previous element
			node.next = prev;
			prev = node;
			node = next;
		}
		// set tail to head
		head = prev;

	}

	@Override
	public Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];

		ListNode<T> node = head;
		int counter = 0;
		while (node != null) {
			array[counter] = node.value;
			node = node.next;
			counter++;
		}
		return array;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		int counter = 1;
		ListNode<T> node = head;
		while (node.next != null) {
			node = node.next;
			counter++;
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public T get(int index) {
		if (index < 0 || isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		ListNode<T> node = head;
		int counter = 0;
		while (node != null && counter < index) {
			node = node.next;
			counter++;
		}

		if (counter < index) {
			throw new IndexOutOfBoundsException();
		}

		return node.value;

	}

	@Override
	public int indexOf(T value) {
		if (isEmpty()) {
			return -1;
		}

		ListNode<T> node = head;
		int counter = 0;
		while (node != null) {
			if (Objects.equals(node.value, value)) {
				return counter;
			}
			node = node.next;
			counter++;
		}

		return -1;
	}

	@Override
	public T set(int index, T value) {
		if (index < 0 || isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		ListNode<T> node = head;
		int counter = 0;
		while (node != null && counter < index) {
			node = node.next;
			counter++;
		}

		if (counter < index) {
			throw new IndexOutOfBoundsException();
		}

		T old = node.value;
		node.value = value;
		return old;
	}

}
