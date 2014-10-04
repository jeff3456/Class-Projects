/* Author: Jefferson Lee
 * Date: 01/29/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Assignment02c 
{
	public static void main(String[] args)
	{
		//Turn the current time to an integer from 65 to 90 then print
		long number = (System.currentTimeMillis()) % 26 + 65;
		System.out.print((char) number);
		//Randomize next two numbers so that the time value is different
		long number2 = (System.currentTimeMillis())/17 % 26 + 65;
		System.out.print((char) number2);
		
		long number3 = (System.currentTimeMillis())/59 % 26 + 65;
		System.out.print((char) number3);
	}
}
