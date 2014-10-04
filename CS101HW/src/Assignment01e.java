/* Author: Jefferson Lee
 * Date: 01/29/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;
public class Assignment01e 
{
	public static void main(String[] args)
	{
		Scanner inputDoubles = new Scanner(System.in);
		Scanner inputStrings = new Scanner(System.in);
		
		System.out.print("What's your name? ");
		String name = inputStrings.nextLine();
		System.out.print("How long is your dorm room, in feet? ");
		double feet = inputDoubles.nextDouble();
		System.out.println("");
		System.out.println("In meters, that's " + (feet * .3048));
		System.out.println("In yards, that's " + (feet/3));
		System.out.println("In inches, that's " + (feet * 12));
		System.out.println("In centimeters, that's " + (feet * 30.48));
	}

}
