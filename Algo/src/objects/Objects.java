package objects;

public class Objects {

	// Available in Java 1.7
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

}
