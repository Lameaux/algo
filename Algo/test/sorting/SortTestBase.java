package sorting;

import static org.junit.Assert.assertArrayEquals;
import helper.Generator;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public abstract class SortTestBase {

	private static final int INT_ARRAY_SIZE = 100;
	private static final int COMPARABLE_ARRAY_SIZE = 100;
	
	private int[] intArray;
	private String[] comparableArray;
	
	private SortingMethod sortingMethod;
	
	protected abstract SortingMethod getSortingMethod();
	
	@Before
	public void init() {
		intArray = Generator.arrayOfRandomNumbers(INT_ARRAY_SIZE);
		comparableArray = Generator.arrayOfRandomStrings(COMPARABLE_ARRAY_SIZE);
		sortingMethod = getSortingMethod();
	}	
	
	@Test
	public void testIntArray() {
		int[] clonedArray = intArray.clone();
		// standard java sort
		Arrays.sort(clonedArray);
		// Sorting Method sort;
		sortingMethod.sortNumbers(intArray);
		assertArrayEquals("Should equal", clonedArray, intArray);
	}

	@Test
	public void testStringArray() {
		String[] clonedArray = comparableArray.clone();
		// standard java sort
		Arrays.sort(clonedArray);
		// Sorting Method sort;
		sortingMethod.sortComparables(comparableArray);
		assertArrayEquals("Should equal", clonedArray, comparableArray);
	}
	
	
}
