package sorting;

import objects.Objects;

/**
 * InsertionSort: playing cards sorting
 * @author sergii.sizov
 *
 */
public class InsertionSort extends SortingMethodBase {

	@Override
	public void sortNumbers(int[] array) {
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j;
			while (i > 0 && array[i - 1] > key) {
				array[i] = array[i - 1];
				i--;
			}
			array[i] = key;
		}
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		for (int j = 1; j < array.length; j++) {
			T key = array[j];
			int i = j;
			while (i > 0 && Objects.greater(array[i - 1], key)) {
				array[i] = array[i - 1];
				i--;
			}
			array[i] = key;
		}
	}	
	
}
