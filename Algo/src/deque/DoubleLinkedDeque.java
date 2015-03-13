package deque;

import java.util.NoSuchElementException;

import list.DoubleListNode;

public class DoubleLinkedDeque<E> implements Deque<E> {

	private DoubleListNode<E> head;
	private DoubleListNode<E> tail;
	
	@Override
	public boolean offerFirst(E value) {
		
		if (empty()) {
			head = tail = new DoubleListNode<E>(value);
		} else {		
			DoubleListNode<E> newHead = new DoubleListNode<E>(value);
			head.previous = newHead;
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

		DoubleListNode<E> newHead = head.next;
		head.next = null;
		if (newHead != null) {
			newHead.previous = null;
		}
		
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
			head = tail = new DoubleListNode<E>(value);
		} else {		
			DoubleListNode<E> newTail = new DoubleListNode<E>(value); 
			newTail.previous = tail;
			tail.next = newTail;
			tail = tail.next;
		}
		return true;
	}

	@Override
	public E popLast() {
		E value = peekLast();
		
		// GC
		tail.value = null;

		DoubleListNode<E> newTail = tail.previous;
		tail.previous = null;
		if (newTail != null) {
			newTail.next = null;
		}
		
		if (head == tail) {
			head = tail = null;
		} else {
			tail = newTail;
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
		DoubleListNode<E> current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

}
