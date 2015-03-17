package objects;

/**
 * Objects util
 * @author sergii.sizov
 *
 */
public class Objects {

	/**
	 * Compares two objects
	 * The same method is available in Java 1.7
	 * @param a
	 * @param b
	 * @return true if equal
	 */
	public static boolean equals(Object a, Object b) {
		return (a == b) || (a != null && a.equals(b));
	}

	/**
	 * Compares two Comparable instances (a<b)
	 * @param a
	 * @param b
	 * @return true if a < b 
	 */
	public static <T extends Comparable<T>> boolean less(T a, T b) {
		if (a == b) return false;
		if (a == null) return false; // null is bigger
		if (b == null) return true;
		return  a.compareTo(b) < 0;
	}

	/**
	 * Compares two Comparable instances (a>b)
	 * @param a
	 * @param b
	 * @return true if a > b 
	 */
	public static <T extends Comparable<T>> boolean greater(T a, T b) {
		if (a == b) return false;
		if (a == null) return true; // null is bigger
		if (b == null) return false;
		return  a.compareTo(b) > 0;
	}
	
	
}
