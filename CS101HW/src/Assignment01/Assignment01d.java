/* Author: Jefferson Lee
 * Date: 01/29/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;
public class Assignment01d 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter x1: ");
		double x = input.nextDouble();
		System.out.print("Enter y1: ");
		double y = input.nextDouble();
		System.out.print("Enter x2: ");
		double x2 = input.nextDouble();
		System.out.print("Enter y2: ");
		double y2 = input.nextDouble();
		double distance = Math.pow( (Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) ), 0.5);
		
		System.out.println("");
		
		System.out.print("Distance between these points is: " + distance );
	}

}
