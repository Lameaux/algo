package sorting;

import helper.Generator;
import helper.Printer;

import java.util.ArrayList;
import java.util.List;

public class SortingComparison {

	private List<SortingMethod> methods = new ArrayList<SortingMethod>(); 

	public static final int ARRAY_SIZE = 10;
	
	public SortingComparison() {
		methods.add(new BubbleSort());
	}
	
	public void start() {
		
		for (SortingMethod method : methods) {
			Printer.println(method.getClass().getSimpleName() + ": " + method.description());
			String[] array = Generator.arrayOfRandomStrings(ARRAY_SIZE);
			Printer.println(array);
			method.sortComparables(array);
			Printer.println(array);			
		}
		
	}
	
	public static void main(String[] args) {
		new SortingComparison().start();
	}
	
	
}
