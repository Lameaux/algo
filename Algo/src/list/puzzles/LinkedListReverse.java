package list.puzzles;

import list.LinkedList;
import structure.ListNode;

public class LinkedListReverse {

	public static void reverseRecursive(LinkedList list) {

		ListNode head = list.getHead();
		ListNode tail = reverse(head);
		list.setHead(tail);
	}

	private static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = null;
		ListNode reversed = reverse(newHead);
		newHead.next = head;

		return reversed;

	}

}
