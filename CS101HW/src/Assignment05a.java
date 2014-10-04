/* Author: Jefferson Lee
 * Date: 03/05/2014
 * Section CS101, Section 03 Spring 2014
 */
public class Assignment05a {

	public static void main(String[] args) 
	{
		int[] theCoins = {1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,10,10,10,10,10,10,25,25,25,25,50,50,50,50};
		boolean a = true;
		while(a != isEmpty(theCoins))
		{
			System.out.println("You picked a coin of value: "+ removeACoin(theCoins));
			printCoinSummary(theCoins);
			System.out.println("------------------------------");
		}
	}
	
	public static void printCoinSummary(int[] coins)
	{
		int pennies = 0;
		int nickels = 0;
		int dimes = 0;
		int quarters = 0;
		int fifty = 0;
		double total = 0;
		for (int i = 0; i < coins.length; i++)
		{
			if(coins[i] == 1)
			{
				pennies++;
				total += .01;
			}
			else if(coins[i] == 5)
			{
				nickels++;
				total += .05;
			}
			else if(coins[i] == 10)
			{
				dimes++;
				total += .1;
			}
			else if(coins[i]==25)
			{
				quarters++;
				total += .25;
			}
			else if(coins[i]== 50)
			{
				fifty++;
				total += .5;
			}
		}
		System.out.printf("Pennies: %10d \n" , pennies);
		System.out.printf("Nickels: %10d \n" , nickels);
		System.out.printf("Dimes: %12d \n" , dimes);
		System.out.printf("Quarters: %9d \n", quarters);
		System.out.printf("50 Cent Pieces : %2d \n", fifty);
		System.out.printf("Money in jar:     $%.2f  \n", total);

	}
	
	public static int removeACoin(int [] coins)
	{
		int temp;
		if(isEmpty(coins))
		{
			return 0;
		}
		while (true)
		{
			// get random coin
			int randomCoin = (int) (Math.random()*(coins.length));
			// make sure it is not 0
			if (coins[randomCoin] != 0)
			{
				temp = coins[randomCoin];
				coins[randomCoin] = 0;
				return temp;
			}
		}
	}
	
	public static boolean isEmpty(int[] coins)
	{
		for(int i =0; i < coins.length;i++)
		{
			if (coins[i] != 0)
			{
				return false;
			}
		}
		return true;
	}
}
