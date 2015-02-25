package sorting;

public class InsertionSort extends SortingMethodBase {

	@Override
	public String description() {
		return "playing cards sorting";
	}

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

}
