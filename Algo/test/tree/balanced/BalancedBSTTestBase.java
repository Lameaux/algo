package tree.balanced;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class BalancedBSTTestBase {

	protected BalancedBST<String, String> tree;

	protected abstract BalancedBST<String, String> getTreeImpl(); 
	
	@Before
	public void init() {
		tree = getTreeImpl();
		assertTrue("Tree is empty", tree.isEmpty());
	}

	@Test
	public void testPut() {
		String value1 = "value1";
		String value2 = "value2";

		assertNull("New element", tree.put(value1, value1));
		assertEquals("Previous element", value1, tree.put(value1, value1));		
		assertFalse("Tree is not empty", tree.isEmpty());
		
		tree.put(value2, value2);
		assertEquals("N = 2", 2, tree.size());
	}

	@Test
	public void testDelete() {
		String value1 = "value1";
		String value2 = "value2";
		String value3 = "value3";
		String value4 = "value4";		

		assertNull("New element", tree.put(value1, value1));
		assertFalse("Tree is not empty", tree.isEmpty());
		
		assertNull("New element", tree.put(value2, value2));
		assertEquals("Exists", value2, tree.put(value2, value2));
		
		assertFalse("Delete not existing", tree.delete(value3));
		
		assertTrue("Delete existing", tree.delete(value1));
		assertNull("New element", tree.put(value1, value1));
		
		assertNull("New element", tree.put(value3, value2));
		
		assertTrue("Delete existing", tree.delete(value1));
		assertTrue("Delete existing", tree.delete(value2));
		assertTrue("Delete existing", tree.delete(value3));
		assertFalse("Delete not existing", tree.delete(value4));		
		
	}	
	
	
	@Test
	public void testToArray() {
		String[] array = new String[] { "1", "2", "3", "4", "5" };
		for (String s : array) {
			tree.put(s,s);
		}
		assertEquals("Compare sizes", array.length, tree.size());
		assertArrayEquals("Compare array", array, tree.toArray());

	}

	
	@Test
	public void testHeight() {

		String value1 = "value1";
		String value2 = "value2";		
		
		assertEquals(0, tree.height());

		tree.put(value1, value1);
		assertEquals(1, tree.height());

		tree.put(value2, value2);
		assertEquals(2, tree.height());		
	}

	@Test
	public void testContains() {

		String value1 = "value1";
		String value2 = "value2";		
		
		assertFalse("Not contains 1", tree.contains(value1));
		tree.put(value1, value1);
		assertTrue("Should contain 1", tree.contains(value1));

		assertFalse("Not contains 2", tree.contains(value2));		
		tree.put(value2, value2);
		assertTrue("Should contain 2", tree.contains(value2));		
	}	

	@Test
	public void testTreeBalanced() {
		int N = 100000;
		for (int i = 0; i < N; i++) {
			tree.put(String.valueOf(i), String.valueOf(i));
			assertTrue("Tree should be balanced", tree.balance() <= 1);
			assertTrue("Tree should be balanced", tree.balance() >= -1);			
		}
		assertEquals(N, tree.size());
	}
	
	
}
