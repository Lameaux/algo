package tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BSTArrayTest {

	BSTArray<String> tree;

	@Before
	public void init() {
		int MAX_TREE_HEIGHT=5;
		tree = new BSTArray<String>(MAX_TREE_HEIGHT);
		assertTrue("Tree is empty", tree.isEmpty());
	}	
	
	@Test
	public void testAdd() {
		String value1 = "value1";
		String value2 = "value2";

		tree.add(value1);
		assertFalse("Tree is not empty", tree.isEmpty());

		tree.add(value2);
		assertEquals("N = 2", 2, tree.size());
	}

	@Test
	public void testContains() {

		String value1 = "value1";
		String value2 = "value2";		
		
		assertFalse("Not contains 1", tree.contains(value1));
		tree.add(value1);
		assertTrue("Should contain 1", tree.contains(value1));

		assertFalse("Not contains 2", tree.contains(value2));		
		tree.add(value2);
		assertTrue("Should contain 2", tree.contains(value2));		
	}	

	@Test
	public void testToArray() {
		String[] array = new String[] { "1", "2", "3", "4", "5" };
		for (String s : array) {
			tree.add(s);
		}
		assertEquals("Compare sizes", array.length, tree.size());
		assertArrayEquals("Compare array", array, tree.toArray());

	}	
	
}
