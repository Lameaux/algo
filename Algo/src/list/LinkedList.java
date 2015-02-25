package list;

import structure.ListNode;

public class LinkedList {

	private ListNode head;
	
	public LinkedList() {
		
	}

	public LinkedList(ListNode head) {
		this.head = head; 
	}
	
	public ListNode getHead() {
		return head;
	}
	
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

	public boolean remove(Object value) {
		if (isEmpty()) {
			return false;
		}

		ListNode node = head;
		ListNode prev = null;
		do {
			if (equal(node.value, value)) {
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

	public void clear() {
		head = null;
	}

	public boolean contains(Object value) {
		if (isEmpty()) {
			return false;
		}

		ListNode node = head;
		while (node != null) {
			if (equal(node.value, value)) {
				return true;
			}
			node = node.next;
		}

		return false;
	}

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

	public boolean isEmpty() {
		return head == null;
	}

	private boolean equal(Object o1, Object o2) {
		if (o1 == null && o2 == null) {
			return true;
		}

		if (o1 != null) {
			return o1.equals(o2);
		}

		return o2.equals(o1);
	}

}
