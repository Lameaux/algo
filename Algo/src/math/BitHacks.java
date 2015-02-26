package math;
/* 
 * http://graphics.stanford.edu/~seander/bithacks.html
 * 
 * */
public class BitHacks {

	public static int multiplyBy31(int x) {
		return (x << 5) - x;
	}
	
	public static int multiplyBy9(int x) {
		return (x << 3) + x;
	}

	public static int divideBy8(int x) {
		return x >> 3 ;
	}	
	
}
