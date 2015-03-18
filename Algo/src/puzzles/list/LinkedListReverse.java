package puzzles.list;

import list.LinkedList;
import list.ListNode;

public class LinkedListReverse {

	public static <T> void reverseRecursive(LinkedList<T> list) {

		ListNode<T> head = list.getHead();
		ListNode<T> tail = reverse(head);
		list.setHead(tail);
	}

	private static <T> ListNode<T> reverse(ListNode<T> head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode<T> newHead = head.next;
		head.next = null;
		ListNode<T> reversed = reverse(newHead);
		newHead.next = head;

		return reversed;

	}

}
