package sorting;

public class BubbleSort extends SortingMethodBase implements SortingMethod {

	@Override
	public String description() {
		return "Very simple implementation of BubbleSort (2 loops)";
	}

	@Override
	public void sortNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}

	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		T tmp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j].compareTo(array[j+1]) > 0) {
					swap(array, j, j + 1);
				}
			}
		}

	}

}
