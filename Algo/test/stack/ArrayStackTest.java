package stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {

	protected Stack<String> stack; 
	
	protected Stack<String> getStackImpl() {
		return new ArrayStack<String>();
	}
	
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
	
}
