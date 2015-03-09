package queue;

import java.util.NoSuchElementException;

import list.ListNode;

public class LinkedQueue<E> implements Queue<E> {

	private ListNode<E> head;
	private ListNode<E> tail;	


	@Override
	public boolean offer(E value) {
		
		if (empty()) {
			head = tail = new ListNode<E>(value);
		} else {
			tail.next = new ListNode<E>(value);
			tail = tail.next;
		}
		
		return true;
	}

	@Override
	public E pop() {
		E value = peek();
		
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
	public E peek() {
		if (empty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return head.value;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public int size() {
		int size=0;
		ListNode<E> curr = head;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		return size;
	}	
	
}
