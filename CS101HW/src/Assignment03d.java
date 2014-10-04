/* Author: Jefferson Q. Lee
 * Date: 02/17/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;

public class Assignment03d 
{
	public static void main(String[] args)
	{
		Scanner inputNum = new Scanner(System.in);
		System.out.print("Enter an integer, 0 to end: ");
		int num = inputNum.nextInt();
		while (num != 0)
		{
			System.out.print(num + " reversed is " + reverse(num)+ ".");
			if (isPalindrome(num))
			{
				System.out.println(" Your number is a palindrome.");
			}
			else
			{
				System.out.println(" Your number is not a palindrome.");
			}
			System.out.print("Enter an integer, 0 to end: ");
			num = inputNum.nextInt();
		}
		
	}
	public static String reverse(int number)
	{
		// reverse a number by rewriting the number by single digits
		// get the remainder after dividing by 10 "somenumber % 10"
		String reversedNumber = "";
		while (number > 0)
		{
			int digit = number % 10;
			number = number/10;
			reversedNumber += String.valueOf(digit);
		}
		return reversedNumber;
		
	}
	public static boolean isPalindrome(int number)
	{
		int b = Integer.parseInt(reverse(number));
		if (number == b)
		{
			return true;
		}
		else 
			return false;
	}
}
