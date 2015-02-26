package list.puzzles;

import list.LinkedList;
import structure.ListNode;


public class ListOperations {

	public static void reverseRecursiveLinkedList(LinkedList list) {
		
		ListNode head = list.getHead();
		ListNode tail = reverseList(head);
		list.setHead(tail);
	}
	
	private static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		
		ListNode newHead = head.next;
		head.next = null;
		ListNode reversed = reverseList(newHead);
		newHead.next=head;

		return reversed;
		
	}
	
}
