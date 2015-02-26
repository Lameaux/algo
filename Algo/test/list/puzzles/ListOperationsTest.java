package list.puzzles;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import list.LinkedList;

import org.junit.Test;

import arrays.Arrays;

public class ListOperationsTest {

	@Test
	public void testReverseRecursiveLinkedList() {

		LinkedList list = new LinkedList();
		int[] array = new int[]{1,2,3,4,5,6};
		for (int a : array) {
			list.add(a);
		}
		assertEquals("Check list size", array.length, list.size());
		
		Object[] listArray = list.toArray();
		Arrays.reverse(listArray);
		
		ListOperations.reverseRecursiveLinkedList(list);
		
		Object[] listArray2 = list.toArray();
		
		assertArrayEquals("Compare reversed arrays", listArray, listArray2);
		
	}

}
