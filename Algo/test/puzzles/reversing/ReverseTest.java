package puzzles.reversing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void testReverseNumber() {
		assertEquals(0, Reverse.reverseNumber(0));
		assertEquals(1, Reverse.reverseNumber(10));
		assertEquals(101, Reverse.reverseNumber(101));
		assertEquals(654321, Reverse.reverseNumber(123456));		
	}

	@Test
	public void testReverseString() {
		assertEquals(null, Reverse.reverseString(null));
		assertEquals("", Reverse.reverseString(""));
		assertEquals("a", Reverse.reverseString("a"));
		assertEquals("654321", Reverse.reverseString("123456"));		
	}
	
	
}
