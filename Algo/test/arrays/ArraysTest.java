package arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void testReverse() {
		Object[] array = new Object[]{1,2,3,4,5,6};
		Object[] array_reversed = new Object[]{6,5,4,3,2,1};
		Arrays.reverse(array);
		assertArrayEquals("Arrays are equal", array_reversed, array);
	}
	
	@Test
	public void testSwap() {
		int[] array = new int[]{1,2,3,4,5,6};
		int[] array_swapped = new int[]{1,3,2,4,5,6};
		Arrays.swap(array, 1, 2);
		assertArrayEquals("Arrays are equal", array_swapped, array);
	}

	@Test
	public void testSwapXOR() {
		int[] array = new int[]{1,2,3,4,5,6};
		int[] array_swapped = new int[]{1,3,2,4,5,6};
		Arrays.swapXOR(array, 1, 2);
		assertArrayEquals("Arrays are equal", array_swapped, array);
	}	
	
}
