package helper;

import java.util.Arrays;


public class Printer {

	public static void println(int[] array) {
		println(Arrays.toString(array));
	}
	
	public static void println(Object[] array) {
		println(Arrays.toString(array));
	}

	public static void println(String str) {
		System.out.println(str);
	}	
	
}
