package list;

import objects.Objects;
import structure.ListNode;

public class LinkedList implements List {

	private ListNode head;

	public LinkedList() {

	}

	public LinkedList(ListNode head) {
		this.head = head;
	}

	public ListNode getHead() {
		return head;
	}

	@Override
	public void add(Object value) {
		ListNode node = new ListNode(value);

		if (isEmpty()) {
			head = node;
			return;
		}

		ListNode last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
	}

	@Override
	public boolean remove(Object value) {
		if (isEmpty()) {
			return false;
		}

		ListNode node = head;
		ListNode prev = null;
		do {
			if (Objects.equals(node.value, value)) {
				if (node == head) {
					head = head.next;
				} else {
					prev.next = node.next;
				}
				return true;
			}
			prev = node;
			node = node.next;
		} while (node != null);

		return false;
	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean contains(Object value) {
		return indexOf(value) != -1;
	}

	@Override
	public void reverse() {
		if (isEmpty()) {
			return;
		}

		ListNode node = head;
		ListNode prev = null;
		while (node != null) {
			// save next reference
			ListNode next = node.next;
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

		ListNode node = head;
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
		ListNode node = head;
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
	public Object get(int index) {
		if (index < 0 || isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		ListNode node = head;
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
	public int indexOf(Object value) {
		if (isEmpty()) {
			return -1;
		}

		ListNode node = head;
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
	public Object set(int index, Object value) {
		if (index < 0 || isEmpty()) {
			throw new IndexOutOfBoundsException();
		}

		ListNode node = head;
		int counter = 0;
		while (node != null && counter < index) {
			node = node.next;
			counter++;
		}

		if (counter < index) {
			throw new IndexOutOfBoundsException();
		}

		Object old = node.value;
		node.value = value;
		return old;
	}

}
