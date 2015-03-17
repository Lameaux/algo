package helper;

import java.util.Random;

public class Generator {

	/**
	 * Return an array of random ints
	 * 
	 * @param size
	 *            number of random ints
	 * @return array
	 */
	public static int[] arrayOfRandomNumbers(int size) {
		int[] array = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = r.nextInt();
		}
		return array;
	}

	/**
	 * Returns an array of random Strings
	 * 
	 * @param size
	 *            number of random Strings
	 * @return array
	 */
	public static String[] arrayOfRandomStrings(int size) {
		String[] array = new String[size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = Integer.toHexString(r.nextInt());
		}
		return array;
	}

}
