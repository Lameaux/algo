package objects;

public class Objects {

	// Available in Java 1.7
	public static boolean equals(Object a, Object b) {
		return (a == b) || (a != null && a.equals(b));
	}

	public static <T extends Comparable<T>> boolean less(T a, T b) {
		if (a == b) return false;
		if (a == null) return false; // null is bigger
		if (b == null) return true;
		return  a.compareTo(b) < 0;
	}

	public static <T extends Comparable<T>> boolean greater(T a, T b) {
		if (a == b) return false;
		if (a == null) return true; // null is bigger
		if (b == null) return false;
		return  a.compareTo(b) > 0;
	}
	
	
}
