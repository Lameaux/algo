package sorting;

import objects.Objects;
import arrays.Arrays;

/**
 * BubbleSort: 2 loops implementation
 * 
 * @author sergii.sizov
 * 
 */
public class BubbleSort extends SortingMethodBase {

	@Override
	public void sortNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					Arrays.swap(array, j, j + 1);
				}
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (Objects.greater(array[j], array[j + 1])) {
					Arrays.swap(array, j, j + 1);
				}
			}
		}
	}

}
