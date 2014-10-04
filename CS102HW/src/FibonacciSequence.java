import java.util.Scanner;


public class FibonacciSequence 
{
	public static void main(String[] args)
	{
		// using a recursion algorithm, design a Fibonacci sequence
		 System.out.print("Enter number up to which Fibonacci series to print: ");
	     int number = new Scanner(System.in).nextInt();
	 
	     System.out.println("\n\nFibonacci series upto " + number +" numbers : ");
	        //printing Fibonacci series upto number
	     for(int i=1; i<=number; i++)
	     {
	    	 System.out.print(fibonacciRecusion(i) +" ");
	     }
	}


	// Java program for Fibonacci number using recursion.
	public static int fibonacciRecusion(int number)
	{
		if(number == 1 || number == 2)
		{
			return 1;
		}
		return fibonacciRecusion(number-1) + fibonacciRecusion(number - 2);
	}

	//Java program for Fibonacci number using Loop
	public static int fibonacciLoop(int number)
	{
		if(number ==1 || number == 2)
		{
			return 1;
		}
		int fibo1 = 1, fibo2 =1, fibonacci = 1;
		for (int i = 3; i <= number; i++)
		{
			fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
	        fibo1 = fibo2;
	        fibo2 = fibonacci;
	        
		}
		return fibonacci;
	}
}