package deque;

import java.util.NoSuchElementException;

import list.ListNode;

public class LinkedDeque<E> implements Deque<E> {

	private ListNode<E> head;
	private ListNode<E> tail;
	
	@Override
	public boolean offerFirst(E value) {
		
		if (empty()) {
			head = tail = new ListNode<E>(value);
		} else {		
			ListNode<E> newHead = new ListNode<E>(value);
			newHead.next = head;
			head = newHead;
		}
		return true;
	}

	@Override
	public E popFirst() {
		E value = peekFirst();
		
		// GC
		head.value = null;

		ListNode<E> newHead = head.next;
		head.next = null;
		
		if (head == tail) {
			head = tail = null;
		} else {
			head = newHead;
		}
		
		return value;
	}

	@Override
	public E peekFirst() {
		if (empty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return head.value;
	}

	@Override
	public boolean offerLast(E value) {
		if (empty()) {
			head = tail = new ListNode<E>(value);
		} else {		
			tail.next = new ListNode<E>(value);
			tail = tail.next;
		}
		return true;
	}

	@Override
	public E popLast() {
		E value = peekLast();
		
		// GC
		tail.value = null;

		if (head == tail) {
			head = tail = null;
		} else {
			
			ListNode<E> current = head;
			while (current.next != tail) {
				current = current.next;
			}
			current.next = null;
			tail = current;
		}
		
		return value;
	}

	@Override
	public E peekLast() {
		if (empty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return tail.value;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public int size() {
		int size = 0;
		ListNode<E> current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

}
