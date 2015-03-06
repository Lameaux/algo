package stack;

import java.util.EmptyStackException;

import list.ListNode;

public class LinkedStack<E> implements Stack<E> {

	private ListNode<E> head;

	@Override
	public E push(E value) {
		ListNode<E> newHead = new ListNode<E>(value);
		newHead.next = head;
		head = newHead;
		return value;
	}

	@Override
	public E pop() {
		E value = peek();
		// GC
		head.value = null;
		// remove head
		ListNode<E> next = head.next;
		head.next = null;
		head = next;
		return value;

	}

	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return head.value;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

}

