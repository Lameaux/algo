package stack;

import static org.junit.Assert.assertEquals;
import helper.Generator;

import org.junit.Test;

import arrays.Arrays;

public class ArrayStackTest extends StackTestBase {

	@Override
	protected Stack<String> getStackImpl() {
		return new ArrayStack<String>();
	}

	@Test
	public void testPushPopBigN() {
		String[] values = Generator.arrayOfRandomStrings(1000);
		for (String v : values) {
			stack.push(v);
		}
		Arrays.reverse(values);
		for (int i = 0; i < values.length; i++) {
			assertEquals("Should be equal", values[i], stack.pop());
		}
	}	
	
}
