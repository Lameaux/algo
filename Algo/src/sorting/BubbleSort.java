package sorting;

import arrays.Arrays;

public class BubbleSort extends SortingMethodBase {

	@Override
	public String description() {
		return "2 loops implementation";
	}

	@Override
	public void sortNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					Arrays.swap(array, j, j + 1);
				}
			}
		}

	}


}
