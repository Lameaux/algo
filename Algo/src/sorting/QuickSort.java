package sorting;

import objects.Objects;
import arrays.Arrays;

/**
 * QuickSort: divide and conquer
 * 
 * @author sergii.sizov
 * 
 */
public class QuickSort extends SortingMethodBase {

	@Override
	public void sortNumbers(int[] array) {
		quickSort(array, 0, array.length - 1);

	}

	private void quickSort(int[] array, int left, int right) {

		int pivotIndex = partition(array, left, right);

		if (left < pivotIndex - 1) {
			quickSort(array, left, pivotIndex - 1);
		}
		if (pivotIndex < right) {
			quickSort(array, pivotIndex, right);
		}

	}

	private int partition(int[] array, int left, int right) {

		int pivot = array[left + (right - left) / 2];

		int i = left;
		int j = right;

		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				Arrays.swap(array, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

	// ---------- COMPARABLES

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		quickSort(array, 0, array.length - 1);

	}

	private <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {

		int pivotIndex = partition(array, left, right);

		if (left < pivotIndex - 1) {
			quickSort(array, left, pivotIndex - 1);
		}
		if (pivotIndex < right) {
			quickSort(array, pivotIndex, right);
		}

	}

	private <T extends Comparable<T>> int partition(T[] array, int left, int right) {

		T pivot = array[left + (right - left) / 2];

		int i = left;
		int j = right;

		while (i <= j) {
			while (Objects.less(array[i], pivot)) {
				i++;
			}
			while (Objects.greater(array[j], pivot)) {
				j--;
			}
			if (i <= j) {
				Arrays.swap(array, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

}
