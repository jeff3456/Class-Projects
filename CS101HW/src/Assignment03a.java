/* Author: Jefferson Q. Lee
 * Date: 02/17/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;
public class Assignment03a 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter start value: ");
		int num1 = input.nextInt();
		System.out.print("Enter end value: ");
		int num2 = input.nextInt();
		
		while (num1 < 33 || num1 > 126 || num2 < 33 || num2 > 126 || num1 >= num2)
		{
			if (num1 < 33 || num1 > 126 || num2 < 33 || num2 > 126)
			{
				System.out.println("Sorry your numbers must be between 33 and 126 (inclusive)");
				System.out.print("Enter start value: ");
				num1 = input.nextInt();
				System.out.print("Enter end value: ");
				num2 = input.nextInt();
			}
			else if (num1 >= num2)
			{
				System.out.println("Sorry, your start value must be less than your end value");
				System.out.print("Enter start value: ");
				num1 = input.nextInt();
				System.out.print("Enter end value: ");
				num2 = input.nextInt();
			}
		}
		
		System.out.println("Here is your ASCII table!");
		int i;
		int count = 0;
		for(i = num1; i < (num2 + 1); i++)
		{
			if (count == 10)
			{
				System.out.println("");
				count = 0;
			}
			System.out.print((char) i);
		count++;
		}
	}
}
