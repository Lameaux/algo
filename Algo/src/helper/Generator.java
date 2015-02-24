package helper;

import java.util.Random;

import entities.TreeNode;

public class Generator {

	public static TreeNode singleNodeTree() {
		return new TreeNode();
	}
	
	public static int[] arrayOfRandomNumbers(int size) {
		
		int[] array = new int[size];
		
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = r.nextInt();
		}
		
		return array;
		
	}

	public static String[] arrayOfRandomStrings(int size) {
		
		String[] array = new String[size];
		
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = Integer.toHexString(r.nextInt());
		}
		
		return array;
		
	}	
	
}
