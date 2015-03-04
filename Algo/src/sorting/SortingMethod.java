package sorting;

public interface SortingMethod {

	<T extends Comparable<T>> void sortComparables(T[] array);
	void sortNumbers(int[] array);

}
