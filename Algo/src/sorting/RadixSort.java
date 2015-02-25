package sorting;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort extends SortingMethodBase {

	@Override
	public String description() {
		return "radix";
	}

	@Override
	public void sortNumbers(int[] array) {

		sortLSD(array, 5);
		
	}

	private void sortLSD(int[] array, int maxDigitSymbols) {
		int mod = 10;
		int div = 1;
		
		Queue<Integer> buckets[] = new Queue[]{
				new LinkedList<Integer>()
		};
		
		for (int i = 0; i < maxDigitSymbols; i++, div *= 10, mod *= 10) {
			for (int j = 0; j < array.length; j++) {
				int bucket = (array[j] % mod) / div;
				buckets[bucket].add(array[j]);
			}
		}
		
		int pos = 0;
		for (int j = 0; j < buckets.length; j++) {
			Integer value = null;
			while ((value = buckets[j].poll())!= null) {
				array[pos++] = value;
			}
		}
	
	}
	
}
