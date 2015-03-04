package sorting;

public abstract class SortingMethodBase implements SortingMethod {

	@Override
	public <T extends Comparable<T>> void sortComparables(T[] array) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void sortNumbers(int[] array) {
		throw new RuntimeException("Not implemented");
	}	
	
}
