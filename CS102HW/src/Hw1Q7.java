import java.util.*;

public class Hw1Q7 
{
	public static void show()
	{
		System.out.println( "I am HW 1");
	}
	public static void main(String[] args)
	{
		Random rNG = new Random(1);
		for(int i = 0; i < 20; i++)
		{
			System.out.println(rNG.nextInt(5));
		}
		
	}
}
