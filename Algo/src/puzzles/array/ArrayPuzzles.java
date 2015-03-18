package puzzles.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayPuzzles {

	/*
	 * Given an array with repeated numbers, print the frequencies of each
	 * number.
	 */
	public static String printFrequencies(int[] array) {
		String result = "";
		if (array.length == 0) {
			return result;
		}

		Arrays.sort(array);

		int number = array[0];
		int cnt = 1;

		for (int i = 1; i < array.length; i++) {
			if (array[i] == number) {
				cnt++;
			} else {
				result += number + ":" + cnt + " ";
				number = array[i];
				cnt = 1;
			}
		}

		result += number + ":" + cnt + " ";

		return result;
	}

	/*
	 * There are 3 kinds of balls in a big array. Red, Green, Blue color balls.
	 * Arrange them in such a way that all the red balls to the left, Green
	 * balls in the middle and Blue balls to the right of the array.
	 */

	public static String[] arrangeBalls1(String[] balls) {

		Arrays.sort(balls, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1 == o2 || o1.equals(o2)) {
					return 0;
				}

				if (o1.equals("R") || o2.equals("B")) {
					return -1;
				} else if (o1.equals("B") || o2.equals("R")) {
					return 1;
				}

				return 0;
			}

		});

		return balls;
	}

	/*
	 * Modified the above question such that, the arrangement should be like,
	 * [R,G,B,R,G,B,R,G,B].
	 */
	public static String[] arrangeBalls2(String[] balls) {
	
		String[] newBalls = new String[balls.length];
		
		int r = 0, g = 0, b = 0;
		int i=0;
		while (i < newBalls.length) {
			
			while (r < balls.length) {
				if (balls[r].equals("R")) {
					newBalls[i++] = balls[r++];
					break;
				}
				r++;
			}
			while (g < balls.length) {
				if (balls[g].equals("G")) {
					newBalls[i++] = balls[g++];
					break;
				}
				g++;
			}
			
			while (b < balls.length) {
				if (balls[b].equals("B")) {
					newBalls[i++] = balls[b++];
					break;
				}
				b++;
			}			
			
		}
		
		return newBalls;
	}
}
