/* Author: Jefferson Q. Lee
 * Date: 02/24/2014
 * Section: CS101, Section 03, Spring 2014
 */

public class Assignment04c 
{

	public static void main(String[] args) 
	{
		//true
		System.out.println( isAnagram("", ""));
		
		//false
		System.out.println( isAnagram("a", "") ); 

		// false
		System.out.println( isAnagram("", "a") );

		// true
		System.out.println( isAnagram("a", "a") ); 

		// true
		System.out.println( isAnagram("a", "A") ); 

		// true
		System.out.println( isAnagram("abc", "AbC") ); 

		// false
		System.out.println( isAnagram("Hello", "Goodbye"));

		// false
		System.out.println( isAnagram("Hello", "World"));

		// true
		System.out.println( isAnagram("Elvis", "Lives") );

		// true
		System.out.println( isAnagram("Clint Eastwood", "Old West action"));

		// true
		System.out.println( isAnagram("Madonna Louise Ciccone", "One cool dance musician"));
	}
	public static boolean isAnagram(String a, String b)
	{
		int count = 0;
		String newA = removeSpaces(a.toLowerCase());
		String newB = removeSpaces(b.toLowerCase());
		if (newA.length() == newB.length())
		{
			for (int i = 0; i< newA.length(); i++)
			{
				if(numberOfChar(newA, newA.charAt(i)) == numberOfChar(newB, newA.charAt(i)))
				{
					count++;
				}
			}
			if (count == newA.length())
			{
				return true;
			}
		}
		return false;
	}
	public static String removeSpaces(String a)
	{
		String noSpace = "";
		for (int i = 0; i< a.length(); i++)
		{
			if(a.charAt(i) != ' ')
			{
				noSpace += a.charAt(i);
			}
		}
		return noSpace;
	}
	public static int numberOfChar(String a, char b)
	{
		int count = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i)== b)
			{
				count++;
			}
		}
		return count;
	}
}
