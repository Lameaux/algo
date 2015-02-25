package sorting;

public abstract class SortingMethodBase implements SortingMethod {

	public void swap(int[] array, int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	public <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		throw new RuntimeException("Not implemented");
	}

}
