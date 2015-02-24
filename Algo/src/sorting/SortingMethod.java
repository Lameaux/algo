package sorting;

public interface SortingMethod {

	String description();
	<T extends Comparable<T>> void sortComparables(T[] array);
	void sortNumbers(int[] array);

}
