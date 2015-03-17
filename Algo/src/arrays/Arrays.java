package arrays;

/**
 * Array Helper
 * @author sergii.sizov
 */
public class Arrays {

	/**
	 * Reverses an array
	 * @param array
	 */
	public static void reverse(Object[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}

	/**
	 * Swaps values in int array
	 * @param array
	 * @param i first element
	 * @param j second element
	 */
	public static void swap(int[] array, int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	/**
	 * Swaps values in Object array 
	 * @param array
	 * @param i first element
	 * @param j second element
	 */
	public static void swap(Object[] array, int i, int j) {
		Object tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	/**
	 * Swaps values in int array without extra variable, using XOR
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swapXOR(int[] array, int i, int j) {
		array[i] = array[i] ^ array[j]; // i^j
		array[j] = array[i] ^ array[j]; // i^j^j = i
		array[i] = array[i] ^ array[j]; // j^j^i = j
	}

	/**
	 * Makes a new bigger array and copies the content
	 * @param array
	 * @param requiredCapacity new size of the array
	 * @return new bigger array
	 */
	public static <T> T[] enlargeAndCopy(T[] array, int requiredCapacity) {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[requiredCapacity];
		System.arraycopy(array, 0, newArray, 0, array.length);
		return newArray;
	}

	/**
	 * Shrinks array to required size
	 * @param array
	 * @param requiredCapacity new size of the array
	 * @return new shrinked array
	 */
	public static <T> T[] shrinkAndCopy(T[] array, int requiredCapacity) {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[requiredCapacity];
		System.arraycopy(array, 0, newArray, 0, requiredCapacity);
		return newArray;
	}

}
