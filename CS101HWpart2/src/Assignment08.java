/*Author: Jefferson Lee
 * Date: 4/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Assignment08 
{

	public static void main(String[] args)
	{
		
		// define our test matrix
		int[][] testMatrix = {  
					{ 5, 2, 4 },
					{ 3, 1, 7 },
					{ 9, 3, 2 }
				     };
		
		// create a new IntegerMatrix object to analyze this matrix
		IntegerMatrix tester = new IntegerMatrix(testMatrix);
		
		// print the matrix
		tester.printMatrix();
		
		// attempt to tamper with the original matrix
		testMatrix[0][0] = 999;

		// print the matrix again - since it has been copied the tampering above should
		// not affect the copy stored in the "tester" object
		tester.printMatrix();
		
		// get the sum of all elements in the Matrix
		System.out.println("Sum of all elements: " + tester.getSumOfAllElements() );
		
		// get the sum of row #2
		System.out.println("Sum of row #2: " + tester.getSumOfRow(2) );

		// get the sum of col #1
		System.out.println("Sum of col #1: " + tester.getSumOfCol(1) );
		
		// find the largest element
		Location largest = tester.findLargest();
		System.out.println("Largest element is: " + largest.value);
		System.out.println(" - it can be found at: " + largest.row + ", " + largest.column);
		
		// find the smallest element
		Location smallest = tester.findSmallest();
		System.out.println("Smallest element is: " + smallest.value);
		System.out.println(" - it can be found at: " + smallest.row + ", " + smallest.column);
		
		// multiply all #'s in the matrix by a factor of 2
		tester.multiplyMatrix(2);

		// print the matrix
		tester.printMatrix();
		
		// create a new location item
		Location testItem = new Location(0,0,123);
		
		// put this item into the matrix
		boolean result = tester.putItem( testItem );
		System.out.println("Successful put? " + result);
		
		// print the matrix
		tester.printMatrix();

		// create another location item
		Location testItem2 = new Location(10,10,999);
		boolean result2 = tester.putItem(testItem2);
		System.out.println("Successful put? " + result2);

		// print the matrix
		tester.printMatrix();
		
	} 
}


