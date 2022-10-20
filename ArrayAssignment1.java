
public class ArrayAssignment1 {

	public static void main(String[] args) {
		
		double[] values = {25.3, 100, -10, -1.5, 13, 98.6, 17, 123.145, 125.6, 123.146};
		double largestValue = Integer.MIN_VALUE;
		int negativeCount = 0;
		
		for (double value : values) {
			
			// print elements in single row
			System.out.print(value + " ");
			
			// find largest element
			if (value > largestValue) {
				largestValue = value;
			}
			
			// count negative elements
			if (value < 0) {
				negativeCount++;
			}
			
		}
		
		//output
		System.out.println();
		System.out.println("The largest element in the array is " + largestValue);
		System.out.println("There are " + negativeCount + " negative numbers in the array");

	}

}
