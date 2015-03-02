package tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BSTRecursiveTest {

	BSTRecursive<String> tree;

	@Before
	public void init() {
		tree = new BSTRecursive<String>();
		assertTrue("Tree is empty", tree.isEmpty());
	}

	@Test
	public void testAdd() {
		String value1 = "value1";
		String value2 = "value2";

		assertTrue("New element", tree.add(value1));
		assertFalse("Tree is not empty", tree.isEmpty());

		assertFalse("Duplicate element", tree.add(value1));		
		
		tree.add(value2);
		assertEquals("N = 2", 2, tree.size());
	}

	@Test
	public void testDelete() {
		String value1 = "value1";
		String value2 = "value2";
		String value3 = "value3";
		String value4 = "value4";		

		assertTrue("New element", tree.add(value1));
		assertFalse("Tree is not empty", tree.isEmpty());
		
		assertTrue("New element", tree.add(value2));
		assertFalse("Exists", tree.add(value2));
		
		assertFalse("Delete not existing", tree.delete(value3));
		
		assertTrue("Delete existing", tree.delete(value1));
		assertTrue("New element", tree.add(value1));
		
		assertTrue("New element", tree.add(value3));
		
		assertTrue("Delete existing", tree.delete(value1));
		assertTrue("Delete existing", tree.delete(value2));
		assertTrue("Delete existing", tree.delete(value3));
		assertFalse("Delete not existing", tree.delete(value4));		
		
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

	@Test
	public void testBigN() {
		int N = 100000;
		for (int i = 0; i < N; i++) {
			tree.add(String.valueOf(i));
		}
		assertEquals(N, tree.size());
	}
	
	@Test
	public void testHeight() {

		String value1 = "value1";
		String value2 = "value2";		
		
		assertEquals(0, tree.height());

		tree.add(value1);
		assertEquals(1, tree.height());

		tree.add(value2);
		assertEquals(2, tree.height());		
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
	
}
