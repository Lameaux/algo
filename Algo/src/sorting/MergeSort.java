package sorting;

public class MergeSort extends SortingMethodBase {

	@Override
	public String description() {
		return "merging with aux array";
	}

	@Override
	public void sortNumbers(int[] array) {
		int[] aux = new int[array.length]; // temporary array for merge operation
		mergeSort(array, 0, array.length - 1, aux);
	}

	private void mergeSort(int[] array, int left, int right, int[] aux) {
		if (left == right) {
			return;
		}

		int middle = (left + right) / 2;
		mergeSort(array, left, middle, aux);
		mergeSort(array, middle + 1, right, aux);
		merge(array, left, middle, right, aux);
	}

	private void merge(int[] array, int left, int middle, int right, int[] aux) {
		int sortedIndex = 0;
		int leftIndex = left;
		int rightIndex = middle + 1;

		while (leftIndex <= middle && rightIndex <= right) {
			if (array[leftIndex] < array[rightIndex]) {
				aux[sortedIndex] = array[leftIndex];
				leftIndex++;
			} else {
				aux[sortedIndex] = array[rightIndex];
				rightIndex++;
			}
			sortedIndex++;
		}

		while (leftIndex <= middle) {
			aux[sortedIndex] = array[leftIndex];
			leftIndex++;
			sortedIndex++;
		}

		while (rightIndex <= right) {
			aux[sortedIndex] = array[rightIndex];
			rightIndex++;
			sortedIndex++;
		}

		// update array
		int sortedLength = right - left + 1;
		for (int i = 0; i < sortedLength; i++) {
			array[left + i] = aux[i];
		}

	}

}
