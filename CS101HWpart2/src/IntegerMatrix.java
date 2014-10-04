/*Author: Jefferson Lee
 * Date: 4/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class IntegerMatrix 
{
	private int [][] numList;
	
	public IntegerMatrix(int[][] numList)
	{
		this.numList = new int [numList.length][numList[0].length];
		for(int row = 0; row < numList.length; row++ )
		{
			for(int column = 0; column < numList[row].length; column++)
			{
				this.numList[row][column] = numList[row][column];
			}
		}
	}
	
	public void printMatrix()
	{
		for(int row = 0; row < numList.length; row++ )
		{
			for(int column = 0; column < numList[row].length; column++)
			{
				System.out.printf("%4d", this.numList[row][column]);
			}
			System.out.println();
		}
	}
	public int getSumOfAllElements()
	{
		int sum = 0;
		for(int row = 0; row < numList.length; row++)
		{
			for(int column = 0 ; column < numList[row].length; column++)
			{
				sum += numList[row][column];
			}
		}
		return sum;
	}
	
	public int getSumOfRow(int index)
	{
		int rowSum = 0;
		for( int column = 0; column < numList[index].length; column++)
		{
			rowSum += numList[index][column];
		}
		return rowSum;
	}
	
	public int getSumOfCol(int index)
	{
		int colSum = 0;
		for( int row = 0; row < numList.length; row++)
		{
			colSum += numList[row][index];
		}
		return colSum;
	}
	
	public void multiplyMatrix(int factor)
	{
		for(int row = 0; row < numList.length; row++)
		{
			for(int column = 0 ; column < numList[row].length; column++)
			{
				numList[row][column] = numList [row][column] * factor;
			}
		}
	}

	public Location findLargest()
	{
		Location largest = new Location(0, 0, numList[0][0]);
		for(int row = 0; row < numList.length; row++)
		{
			for(int column = 0 ; column < numList[row].length; column++)
			{
				if(largest.value < numList[row][column])
				{
					largest.value = numList[row][column];
					largest.column = column;
					largest.row = row;
				}
			}
		}
		return largest;
	}
	
	public Location findSmallest()
	{
		Location smallest = new Location(0,0,numList[0][0]);
		for(int row = 0; row < numList.length; row++)
		{
			for(int column = 0 ; column < numList[row].length; column++)
			{
				if(smallest.value > numList[row][column])
				{
					smallest.value = numList[row][column];
					smallest.column = column;
					smallest.row = row;
				}
			}
		}
		return smallest;		
	}
	
	public boolean putItem(Location reference)
	{
		if((reference.row <= numList.length) && ( reference.column <= numList[reference.row].length))
		{
			numList[reference.row][reference.column] = reference.value;
			return true;
		}
		return false;
	}
	
}
