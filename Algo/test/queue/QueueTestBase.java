package queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import helper.Generator;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public abstract class QueueTestBase {

	protected Queue<String> queue;

	protected abstract Queue<String> getQueueImpl();

	@Before
	public void init() {
		queue = getQueueImpl();
		assertTrue("Queue is empty", queue.empty());
	}

	@Test
	public void testEmpty() {
		String value = "value";
		assertTrue("Add success", queue.offer(value));
		assertFalse("Queue is not empty", queue.empty());
	}

	@Test
	public void testPushPop() {
		String[] values = new String[] { "a", "b", "c", "d", "e" };
		for (String v : values) {
			assertTrue("Add success", queue.offer(v));
		}

		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], queue.pop());
		}
	}

	@Test
	public void testPeek() {
		String value = "value";
		queue.offer(value);
		for (int i = 0; i < 3; i++) {
			assertEquals("Should be equal", value, queue.peek());
		}
		assertEquals("Should be equal", value, queue.pop());
		assertTrue("Queue is empty", queue.empty());
		try {
			queue.peek();
			fail("Should throw NoSuchElementException");
		} catch (NoSuchElementException e) {
		}
	}

	@Test
	public void testPushPopBigN() {
		int bigN = 1000;
		String[] values = Generator.arrayOfRandomStrings(bigN);
		for (String v : values) {
			queue.offer(v);
		}
		// get half
		for (int i = 0; i < bigN / 2; i++) {
			assertEquals("Should be equal", values[i], queue.pop());
		}

		String[] values2 = Generator.arrayOfRandomStrings(bigN);
		for (String v : values2) {
			queue.offer(v);
		}

		// get another half
		for (int i = bigN / 2; i < bigN; i++) {
			assertEquals("Should be equal", values[i], queue.pop());
		}

		// get all half
		for (int i = 0; i < bigN; i++) {
			assertEquals("Should be equal", values2[i], queue.pop());
		}

	}

}
