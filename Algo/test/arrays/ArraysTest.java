package arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void testReverse() {
		Object[] array = new Object[]{1,2,3,4,5,6};
		Object[] array_reversed = new Object[]{6,5,4,3,2,1};
		Arrays.reverse(array);
		assertArrayEquals("Arrays are equal", array_reversed, array);
	}

}
