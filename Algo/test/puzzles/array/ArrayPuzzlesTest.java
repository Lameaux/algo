package puzzles.array;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayPuzzlesTest {

	@Test
	public void testPrintFrequencies() {
		assertEquals("", ArrayPuzzles.printFrequencies(new int[] {}));
		assertEquals("1:1 2:5 ", ArrayPuzzles.printFrequencies(new int[] { 2, 2, 2, 1, 2, 2 }));
		assertEquals("1:1 2:5 5:1 6:1 10:1 ", ArrayPuzzles.printFrequencies(new int[] { 5, 6, 2, 2, 2, 1, 2, 2, 10 }));
	}

	@Test
	public void testArrangeBalls1() {
		assertArrayEquals(new String[] { "R", "R", "G", "G", "B", "B" }, 
				ArrayPuzzles.arrangeBalls1(new String[] { "R", "B", "G", "B", "R", "G" }));
	}

	@Test
	public void testArrangeBalls2() {
		assertArrayEquals(new String[] { "R", "G", "B", "R", "G", "B" }, 
				ArrayPuzzles.arrangeBalls2(new String[] { "R", "R", "G", "G", "B", "B" }));
	}
	
	
}
