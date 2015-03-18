package puzzles.reversing;

public class Reverse {

	public static int reverseNumber(int number) {
		int reversed = 0;
		while (number != 0) {
			reversed = reversed * 10 + number % 10;
			number = number / 10;
		}
		return reversed;
	}

	public static String reverseString(String s) {
		if (s == null) {
			return null;
		}
		String reversed = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed = reversed + s.charAt(i);
		}

		return reversed;
	}

}
