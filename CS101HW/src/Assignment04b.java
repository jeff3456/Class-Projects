/* Author: Jefferson Lee
 * Date: 02/28/2014
 * Class: CS101 Section 03 Spring 2014
 */

public class Assignment04b {

	public static void main(String[] args) 
	{
		int[] sourceArray = {1,4,5,4,1,2,3,5,9,7,12,-5,1,4,-1,-5,12,1};
		System.out.println( java.util.Arrays.toString( sourceArray ));
		
		int[] newArray = eliminateDuplicates(sourceArray);
		System.out.println( java.util.Arrays.toString( newArray ));
	}
	public static int[] eliminateDuplicates(int[] list)
	{
		int count = 0;
		int [] tempArray = new int[list.length];
		for (int i = 0 ; i < list.length; i++)
		{
			if(list[i]== 0 )
			{
				count++;
			}
			if(findArrayItem(tempArray,list[i]))
			{
				tempArray[i] = list[i];
			}
		}
		//if there is a zero in the array add one additional element to the array
		if(count > 0)
		{
			count = 1;
			for (int i = 0; i < tempArray.length; i++)
			{
				if(tempArray[i] != 0)
				{
					count++;
				}
			}
		}
		else
		{
			// counter for the number of unique elements
			count = 0;
			for (int i = 0; i < tempArray.length; i++)
			{
				if(tempArray[i] != 0)
				{
					count++;
				}
			}
		}
		
		// the count variable is the number of unique elements including 0 if there is a 0
		int [] shortArray = new int [count];
		
		// set up another count variable to represent the index in which the unique variable
		// goes into the shortArray
		count = 0;
		for(int i = 0; i < list.length; i++)
		{
			if(tempArray[i] != 0)
			{
				shortArray[count]= list[i];
				count++;
			}
		}
		
		return shortArray;
	}
	
	public static boolean findArrayItem(int[] list, int num)
	{
		for (int i = 0; i < list.length; i++)
		{
			if(list[i] == num)
			{
				return false;
			}
		}
		return true;
	}
}

