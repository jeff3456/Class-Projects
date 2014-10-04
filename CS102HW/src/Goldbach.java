import java.util.Scanner;

// Goldbach's conjecture is that every even number greater than 2 can be represented
// as the sum of 2 prime numbers
public class Goldbach 
{
	public static void main(String[] args)
	{
		// Must ask user for how many numbers to find.
		
		Scanner numInput = new Scanner(System.in);
		System.out.println("How many Goldbach numbers do you want to find?");
				
		// Then make sure that there is a counter that finds that many numbers
		// Then make a while loop that checks the number for Goldbach's rule
		
		
	}
	// create method that return true if the number is a Goldbach number
	
	public static boolean goldbachCheck(int number)
	{
		// go through list of prime numbers.
		return false;
	}
	
	//method for checking prime numbers
	public static boolean checkPrime(int number)
	{
		// counter of factors
		int factors = 0;
		
		//exceptional case of 1, which is not a prime
		if(number == 1)
		{
			return false;
		}
		
		// for loop that searches for all factors and ++ if it is a factors
		for(int i = 1; i <= number; i++ )
		{
			
			if((number % i) == 0)
			{
				factors++;
			}
			if(factors > 2)
			{
				return false;
			}
		}
		// if there are only 2 factors then the number is prime!
		if(factors == 2)
		{
			return true;
		}
		return false;
	}
}
