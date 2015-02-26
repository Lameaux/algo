package list;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import arrays.Arrays;

public class ArrayListTest {

	ArrayList list;

	@Before
	public void init() {
		list = new ArrayList();
		assertTrue("List is empty", list.isEmpty());
	}

	@Test
	public void testEmpty() {
		String value = "value";
		list.add(value);
		assertFalse("List is not empty", list.isEmpty());
	}

	@Test
	public void testClear() {
		String value = "value";
		list.add(value);
		assertFalse("List is not empty", list.isEmpty());
		list.clear();
		assertTrue("List is empty", list.isEmpty());
	}	
	
	@Test
	public void testSize() {
		assertEquals("Size = 0", 0, list.size());
		String value = "value";
		list.add(value);
		assertEquals("Size = 1", 1, list.size());
	}

	@Test
	public void testAddRemoveHead() {
		String value = "value";
		list.add(value);
		assertFalse("List is not empty", list.isEmpty());
		list.remove(value);
		assertTrue("List is empty", list.isEmpty());
	}

	@Test
	public void testAddRemoveNull() {
		String value = null;
		list.add(value);
		assertFalse("List is not empty", list.isEmpty());
		assertTrue("null exists", list.contains(value));
		list.remove(value);
		assertTrue("List is empty", list.isEmpty());
	}	
	
	@Test
	public void testAddRemoveMore() {

		String value1 = "value1";
		String value2 = "value2";
		String value3 = "value3";

		list.add(value1);
		list.add(value2);		
		assertFalse("List is not empty", list.isEmpty());
		assertEquals("Size = 2", 2, list.size());
		assertFalse("Unable to delete unexisting", list.remove(value3));
		list.remove(value1);
		assertEquals("Size = 1", 1, list.size());
		list.remove(value2);		
		assertTrue("List is empty", list.isEmpty());
	}

	@Test
	public void testContains() {
		String value1 = "value1";
		String value2 = "value2";
		list.add(value1);	
		assertTrue("value1 exists", list.contains(value1));
		assertFalse("value1 does not exist", list.contains(value2));		
	}
	
	@Test
	public void testToArray() {
		Object[] array = new Object[]{1,2,3,4,5,6};
		for (Object o : array) {
			list.add(o);
		}
		assertEquals("List size = Array length", array.length, list.size());
		Object[] array2 = list.toArray();
		assertArrayEquals("Arrays should be equal", array, array2);
	}
	
	@Test
	public void testReverse() {
		Object[] array = new Object[]{1,2,3,4,5,6};
		Object[] array_reversed = array.clone();
		Arrays.reverse(array_reversed);

		for (Object o : array) {
			list.add(o);
		}
		assertEquals("List size = Array length", array.length, list.size());
		list.reverse();
		Object[] array2 = list.toArray();
		assertArrayEquals("Arrays should be equal", array_reversed, array2);
		
		
	}

	@Test
	public void testGet() {
		try {
			list.get(-1);
			fail("Invalid index");
		} catch(IndexOutOfBoundsException e) {
		}
		
		try {
			list.get(list.size());
			fail("Invalid index");
		} catch(IndexOutOfBoundsException e) {
		}

		String value1 = "value1";
		String value2 = "value2";		
		
		list.add(value1);
		list.add(value2);
		
		assertEquals("0->value1", value1, list.get(0));
		assertEquals("1->value2", value2, list.get(1));
		
	}

	@Test
	public void testIndexOf() {

		String value1 = "value1";
		String value2 = "value2";		
		String value3 = "value3";
		
		list.add(value1);
		list.add(value2);
		
		assertEquals("0->value1", 0, list.indexOf(value1));
		assertEquals("1->value2", 1, list.indexOf(value2));
		assertEquals("-1->value3", -1, list.indexOf(value3));		
		
	}		

	@Test
	public void testSet() {
		String value1 = "value1";
		String value2 = "value2";	
		list.add(value1);
		assertEquals("0->value1", 0, list.indexOf(value1));
		Object old = list.set(0, value2);
		assertEquals("old->value1", value1, old);
		assertEquals("0->value2", 0, list.indexOf(value2));
		
	}	
	
	@Test
	public void testTrimToSize() {
		String value1 = "value1";
		list.add(value1);
		assertEquals("Size = 1", 1, list.size());
		list.trimToSize();
		assertEquals("Size = 1", 1, list.size());
		
		
		try {
			Field f = list.getClass().getDeclaredField("array");
			f.setAccessible(true);
			Object[] array = (Object[])f.get(list);
			assertEquals("Size = 1", 1, array.length);
		} catch (Exception e) {
			fail("Unable to check the size");
		}
		
		
	}
	
}
