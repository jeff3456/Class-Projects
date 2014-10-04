/* Author: Jefferson Lee
 * Date: 01/29/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;
public class Assignment02b 
{
	public static void main(String[] args)
	{
		Scanner numInput = new Scanner(System.in);
		
		System.out.print("Enter the exchange rate from dollars to Euros: ");
		double rate = numInput.nextDouble();
		System.out.print("Enter 1 to convert Dollars -> Euros , 2 to convert Euros->Dollars: ");
		int option = numInput.nextInt();
		
		if (option == 1)
		{
			System.out.print("Enter the Dollar amount: ");
			double money = numInput.nextDouble();
			double euros = money * rate;
			System.out.printf("$" + money + " is %.2f Euros", euros);
		}
		else if (option == 2)
		{
			System.out.print("Enter the Euro amount: ");
			double euros = numInput.nextDouble();
			double dollars = euros / rate;
			System.out.printf(euros + " Euros is $%.2f", dollars);
		}
		else
		{
			System.out.print("Error: You didn't enter 1 or 2!");
		}
	}
}
