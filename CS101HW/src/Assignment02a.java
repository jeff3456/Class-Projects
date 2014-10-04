import java.util.Scanner;


/* Author: Craig Kapp
 * Date: 02/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Assignment02a 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Where is your circle located?");
		System.out.print("X position: ");
		double xPos = input.nextDouble();
		System.out.print("Y position: ");
		double yPos = input.nextDouble();
		System.out.print("What is the radius of the circle? ");
		double radius = input.nextDouble();
		
		System.out.println("Great! Now let's test a point to see if it is inside your circle");
		System.out.print("Enter an X position: ");
		double xPoint = input.nextDouble();
		System.out.print("Enter a Y position: ");
		double yPoint = input.nextDouble();
		
		// Calculate the distance the point is from center
		
		double xDistance = xPos - xPoint;
		double yDistance = yPos - yPoint;
		double distance = Math.pow( Math.pow(xDistance, 2)+ Math.pow(yDistance, 2) , .5);
		if (distance < radius)
		{
			System.out.println("Point (" + xPoint + "," + yPoint + ") is inside your circle! ");
		}
		else if (distance == radius)
		{
			System.out.println("Point (" + xPoint + "," + yPoint + ") is on the edge of your circle! ");
		}
		else
		{
			System.out.println("Point (" + xPoint + "," + yPoint + ") is outside of your circle! ");
		}
	}

}
