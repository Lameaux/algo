package math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitHacksTest {

	@Test
	public void testMultiplyBy31() {
		
		int number = 123;
		int result = BitHacks.multiplyBy31(number);
		
		assertEquals("x*31=", number*31, result);
	}

	@Test
	public void testMultiplyBy9() {
		
		int number = 123;
		int result = BitHacks.multiplyBy9(number);
		
		assertEquals("x*9=", number*9, result);
	}	

	@Test
	public void testDivideBy8() {
		
		int number = 123;
		int result = BitHacks.divideBy8(number);
		
		assertEquals("x/8=", (int)(number/8), result);
	}	
	
}
