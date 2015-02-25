package sorting;

import arrays.Arrays;

public class BubbleSortWithFlag extends SortingMethodBase {

	@Override
	public String description() {
		return "Implementation using flag";
	}

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


}
