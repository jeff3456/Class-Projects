/* Author: Jefferson Lee
 * Date: 3/27/2014
 * Section: CS101 section 3 Spring 2014
 */
import java.util.Scanner;
public class Assignment07b 
{
	public static void main(String[] args)
	{
		Scanner inputString = new Scanner(System.in);
		Scanner inputNum = new Scanner(System.in);
		System.out.print("How many Cities? ");
		int numCities = inputNum.nextInt();
		City[] myCities = new City [numCities];
		for(int i = 0; i < numCities; i++)
		{
			System.out.println("City # "+ (i+1));
			System.out.print("Eneter Name: ");
			String name = inputString.nextLine();
			System.out.print("Enter longitude: ");
			double longitude = inputNum.nextDouble();
			System.out.print("Enter latitude: ");
			double latitude = inputNum.nextDouble();
			System.out.println();
			myCities[i] = new City( name, longitude, latitude);
		}
		for(int i = 0; i < numCities; i++)
		{
			for(int j = 0; j < numCities; j++)
			{
				if(myCities[i] != myCities[j])
				{
					System.out.println(myCities[i].name + " is " + myCities[i].distanceFrom(myCities[j]) + " units away from " + myCities[j].name);
				}
			}
		}
	}
}
