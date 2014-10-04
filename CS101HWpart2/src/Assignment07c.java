/* Author: Jefferson Lee
 * Date: 3/27/2014
 * Section: CS101 section 3 Spring 2014
 */
import java.util.Scanner;
public class Assignment07c 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number of random intems to sort (i.e. 100000): ");
		int numItem = input.nextInt();
		CodeTimer a = new CodeTimer();
		int[] arrayA = new int[numItem];
		int[] arrayB = new int[numItem];
		a.start();
		for (int i = 0; i < numItem; i ++)
		{
			int randomNum = (int) (Math.random() * numItem);
			arrayA[i] = randomNum;
			arrayB[i] = randomNum;
		}
		a.stop();
		System.out.println("It took " + a.getElapsedTime() + " seconds to create the array.");
		int count = 0;
		a.start();
		for(int i = 0; i < arrayA.length; i++)
		{
			for(int j = i; j < arrayA.length; j++)
			{
				if(arrayA[i] > arrayA[j])
				{
					int temp = arrayA[i];
					arrayA[i] = arrayA[j];
					arrayA[j] = temp;
				}
			}
		}
		a.stop();
		System.out.println(a.getElapsedTime() + " seconds to use selection sort");
		a.start();
		java.util.Arrays.sort(arrayB);
		a.stop();
		System.out.println(a.getElapsedTime() + " seconds to sort array using the java.util.Arrays.sort() method");
	}
}
