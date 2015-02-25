package sorting;

import helper.Generator;
import helper.Printer;
import helper.Timer;

import java.util.ArrayList;
import java.util.List;

public class SortingComparison {

	private List<SortingMethod> methods = new ArrayList<SortingMethod>();

	public static final int[] ARRAY_SIZES = { 5 }; //{100, 2000, 5000, 10000 };

	public SortingComparison() {
		methods.add(new BubbleSort());
		methods.add(new BubbleSortWithFlag());
		methods.add(new InsertionSort());
		methods.add(new MergeSort());
		methods.add(new QuickSort());
		//methods.add(new RadixSort());
	}

	public void start() {

		for (int ARRAY_SIZE : ARRAY_SIZES) {
			Printer.println("ARRAY_SIZE = " + ARRAY_SIZE);
			int[] array_example = Generator.arrayOfRandomNumbers(ARRAY_SIZE);
			
			for (SortingMethod method : methods) {
				int[] array = array_example.clone();
				Timer t = new Timer();
				method.sortNumbers(array);
				t.end();
				Printer.println(method.getClass().getSimpleName() + ": int[" + ARRAY_SIZE + "] = " + t.getDiffNicely());
				//Printer.println(array);

			}

		}

	}

	public static void main(String[] args) {
		new SortingComparison().start();
	}

}
