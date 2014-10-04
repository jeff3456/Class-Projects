/* Author: Jefferson Q. Lee
 * Date: 02/17/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Assignment03c 
{
	public static void main(String[] args)
	{
		System.out.println("Start     End");
		int i;
		for(i=0; i < 100 ; i++)
		{
			System.out.printf("%5d", i);
			System.out.printf("%8d   \n", messUp(i));		}
	}
	public static int messUp(int number)
	{
		if (number % 5 == 0 && number % 2 == 1)
		{
			number = number / 7 * 3;
		}
		else if (number % 5 == 0 && number % 2 == 0)
		{
			number = number / 7 * 2;
		}
		else if (number % 5 == 0)
		{
			number = number / 7;
		}
		else if (number % 2 == 0)
		{
			number = number * 2;
		}
		else
		{
			number = number * 3;
		}
		return number;
	}
	
}
