package stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import arrays.Arrays;

public abstract class StackTestBase {

	protected Stack<String> stack;

	protected abstract Stack<String> getStackImpl();

	@Before
	public void init() {
		stack = getStackImpl();
		assertTrue("Stack is empty", stack.empty());
	}

	@Test
	public void testEmpty() {
		String value = "value";
		stack.push(value);
		assertFalse("Stack is not empty", stack.empty());
	}

	@Test
	public void testSize() {
		assertEquals("0", 0, stack.size());
		String value = "value";
		assertEquals(value, stack.push(value));
		assertEquals("1", 1, stack.size());
		for (int i = 0; i < 10; i++ ) {
			assertEquals(value, stack.push(value));
		}
		assertEquals("11", 11, stack.size());
	}	
	
	@Test
	public void testPushPop() {
		String[] values = new String[] { "a", "b", "c", "d", "e" };
		for (String v : values) {
			stack.push(v);
		}
		Arrays.reverse(values);
		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], stack.pop());
		}
	}

	@Test
	public void testPeek() {
		String value = "value";
		stack.push(value);
		for (int i = 0; i < 3; i++) {
			assertEquals("Should be equal", value, stack.peek());
		}
		assertEquals("Should be equal", value, stack.pop());
		assertTrue("Stack is empty", stack.empty());
		try {
			stack.peek();
			fail("Should throw EmptyStackException");
		} catch (EmptyStackException e) {
		}
	}

}
