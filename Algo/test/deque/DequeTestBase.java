package deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import arrays.Arrays;

public abstract class DequeTestBase {

	protected Deque<String> deque;

	protected abstract Deque<String> getDequeImpl();

	@Before
	public void init() {
		deque = getDequeImpl();
		assertTrue("Deque is empty", deque.empty());
	}

	@Test
	public void testEmpty() {
		String value = "value";
		deque.offerFirst(value);
		assertFalse("Deque is not empty", deque.empty());
	}

	@Test
	public void testSize() {
		assertEquals("0", 0, deque.size());
		String value = "value";
		assertTrue(deque.offerFirst(value));
		assertEquals("1", 1, deque.size());
		for (int i = 0; i < 10; i++ ) {
			assertTrue(deque.offerFirst(value));
		}
		assertEquals("11", 11, deque.size());
	}	
	
	@Test
	public void testPushPopFirst() {
		String[] values = new String[] { "a", "b", "c", "d", "e" };
		for (String v : values) {
			deque.offerFirst(v);
		}
		Arrays.reverse(values);
		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], deque.popFirst());
		}
	}

	@Test
	public void testPeekFirst() {
		String value = "value";
		deque.offerFirst(value);
		for (int i = 0; i < 3; i++) {
			assertEquals("Should be equal", value, deque.peekFirst());
		}
		assertEquals("Should be equal", value, deque.popFirst());
		assertTrue("Deque is empty", deque.empty());
		try {
			deque.peekFirst();
			fail("Should throw NoSuchElementException");
		} catch (NoSuchElementException e) {
		}
	}

	@Test
	public void testPushPopLast() {
		String[] values = new String[] { "a", "b", "c", "d", "e" };
		for (String v : values) {
			deque.offerLast(v);
		}
		Arrays.reverse(values);
		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], deque.popLast());
		}
	}

	@Test
	public void testPeekLast() {
		String value = "value";
		deque.offerLast(value);
		for (int i = 0; i < 3; i++) {
			assertEquals("Should be equal", value, deque.peekLast());
		}
		assertEquals("Should be equal", value, deque.popLast());
		assertTrue("Deque is empty", deque.empty());
		try {
			deque.peekLast();
			fail("Should throw NoSuchElementException");
		} catch (NoSuchElementException e) {
		}
	}	

	@Test
	public void testPushLastPopFirst() {
		String[] values = new String[] { "a", "b", "c", "d", "e" };
		for (String v : values) {
			assertTrue("Add success", deque.offerLast(v));
		}

		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], deque.popFirst());
		}
	}	
	
}
