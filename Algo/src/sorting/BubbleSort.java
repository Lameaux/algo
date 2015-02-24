package sorting;

public class BubbleSort implements SortingMethod {


	@Override
	public String description() {
		return "Very simple implementation of BubbleSort (2 loops)";
	}	

	@Override
	public void sortNumbers(int[] array) {
		int tmp;
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array.length - 1; j++) {
				if (array[j] > array[i]) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		T tmp;
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array.length - 1; j++) {
				if (array[j].compareTo(array[i]) > 0) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		
	}


}
