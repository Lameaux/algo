package sorting;

import objects.Objects;
import arrays.Arrays;

/**
 * BubbleSortWithFlag: Implementation using flag
 * 
 * @author sergii.sizov
 * 
 */
public class BubbleSortWithFlag extends SortingMethodBase {

	@Override
	public void sortNumbers(int[] array) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					Arrays.swap(array, j, j + 1);
					flag = true; // there was a swap
				}
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (Objects.greater(array[j], array[j + 1])) {
					Arrays.swap(array, j, j + 1);
					flag = true; // there was a swap
				}
			}
		}
	}

}
