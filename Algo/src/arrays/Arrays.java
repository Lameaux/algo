package arrays;

public class Arrays {

	public static void reverse(Object[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	public static void swap(Object[] array, int i, int j) {
		Object tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	public static void swapXOR(int[] array, int i, int j) {
		array[i] = array[i] ^ array[j]; // i^j
		array[j] = array[i] ^ array[j]; // i^j^j = i
		array[i] = array[i] ^ array[j]; // j^j^i = j
	}
}
