package sorting;

import objects.Objects;
import arrays.Arrays;

/**
 * SelectionSort: moving highest to the end
 * 
 * @author sergii.sizov
 * 
 */
public class SelectionSort extends SortingMethodBase {

	@Override
	public void sortNumbers(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			int biggestIndex = 0;
			for (int j = 1; j < array.length - i; j++) {
				if (array[j] > array[biggestIndex]) {
					biggestIndex = j;
				}
				// move to the end (array.length - 1 - i)
				Arrays.swap(array, biggestIndex, array.length - 1 - i);
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			int biggestIndex = 0;
			for (int j = 1; j < array.length - i; j++) {
				if (Objects.greater(array[j], array[biggestIndex])) {
					biggestIndex = j;
				}
				// move to the end (array.length - 1 - i)
				Arrays.swap(array, biggestIndex, array.length - 1 - i);
			}
		}
	}	
	
}
