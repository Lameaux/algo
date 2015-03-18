package puzzles.list;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import list.LinkedList;

import org.junit.Test;

import puzzles.list.LinkedListReverse;
import arrays.Arrays;

public class LinkedListReverseTest {

	@Test
	public void testReverseRecursiveLinkedList() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		Integer[] array = new Integer[]{1,2,3,4,5,6};
		for (Integer a : array) {
			list.add(a);
		}
		assertEquals("Check list size", array.length, list.size());
		
		Object[] listArray = list.toArray();
		Arrays.reverse(listArray);
		
		LinkedListReverse.reverseRecursive(list);
		
		Object[] listArray2 = list.toArray();
		
		assertArrayEquals("Compare reversed arrays", listArray, listArray2);
		
	}

}
