/* Author: Jefferson Q. Lee
 * Date: 02/17/2014
 * Section: CS101, Section 03, Spring 2014
 */

public class Assignment03b 
{
	public static void main(String[] args)
	{
		int i;
		int fourtyPts = 0;
		int thirtyPts = 0;
		int twentyPts = 0;
		int tenPts = 0;
		int miss = 0;
		for(i=0 ; i < 1000000; i++)
		{
			double maxX = 48.;
			double maxY = 60.;
			double randomX = (Math.random() * (maxX + 1));
			double randomY = (Math.random() * (maxY +1));
			
			double distanceFrom40 = Math.pow(Math.pow(randomX - 24, 2) + Math.pow(randomY - 5,2) , .5);
			double distanceFrom30 = Math.pow(Math.pow(randomX - 24, 2) + Math.pow(randomY - 26,2) , .5);
			double distanceFrom20 = Math.pow(Math.pow(randomX - 24, 2) + Math.pow(randomY - 38,2) , .5);
			double distanceFrom10 = Math.pow(Math.pow(randomX - 24, 2) + Math.pow(randomY - 38,2) , .5);
	
			if (distanceFrom40 <= 4.)
			{
				fourtyPts++;
			}
			else if (distanceFrom30 <= 5.)
			{
				thirtyPts++;
			}
			else if (distanceFrom20 <= 6.)
			{
				twentyPts++;
			}
			else if (distanceFrom10 <= 18.)
			{
				tenPts++;
			}
			else
			{
				miss++;
			}
		}
		System.out.println("Total hits: 1000000");
		
		System.out.print("Hits Missed: " + miss + " ");
		System.out.printf("(%.2f", miss/10000.);
		System.out.println("%)");
		System.out.print("Hits 40: " + fourtyPts+ " ");
		System.out.printf("(%.2f", fourtyPts/10000.);
		System.out.println("%)");
		System.out.print("Hits 30: " + thirtyPts+ " ");
		System.out.printf("(%.2f", thirtyPts/10000.);
		System.out.println("%)");
		System.out.print("Hits 20: " + twentyPts+ " ");
		System.out.printf("(%.2f", twentyPts/10000.);
		System.out.println("%)");
		System.out.print("Hits 10: " + tenPts+ " ");
		System.out.printf("(%.2f", tenPts/10000.);
		System.out.println("%)");
	}
}
