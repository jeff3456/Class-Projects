/* Author: Jefferson Lee
 * Date: 03/12/2014
 * Section CS101, Section 03 Spring 2014
 */
public class theGameOfLife {

	public static void main(String[] args) 
	{
		int generation = 1;
		int row = 20;
		int column = 20;
		char [][] board = new char [row][column];
		clearBoard(board);
		randomizeCreatures(board,.12);
		System.out.println("Generation: "+ generation++);
		printBoard(board);
		for(int i = 0; i < 99; i++)
		{
			runGame(board);
			System.out.println("Generation: " + generation++);
			printBoard(board);
		}
	}
	public static void clearBoard(char[][] board)
	{
		char empty = ' ';
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				board[row][column] = empty;
			}
		}
	}
	public static void randomizeCreatures(char [][]board, double chance)
	{
		char alive = 'o';
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				if(Math.random() <= chance)
				{
					board[row][column] = alive;
				}
			}
		}
	}
	public static void printBoard(char[][] board)
	{
		int count = 1;
		for(int row = 0; row < board.length; row++)
		{
			System.out.printf("%3d ", count++);
			for(int column = 0; column < board[row].length; column++)
			{
				System.out.print(board[row][column] + " ");
				if(column == board[row].length -1)
				{
					System.out.println();
				}
			}
		}
	}
	public static void runGame(char[][] board)
	{
		char [][] tempArray = new char [board.length][board.length];
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				int aliveCount = 0;
				if(row != 0)
				{
					if(board[row-1][column] == 'o')
					{
						aliveCount++;
					}
				}
				if(column != 0)
				{
					if(board[row][column-1] == 'o')
					{
						aliveCount++;
					}
				}
				if(row != 0 && column != 0)
				{
					if(board[row-1][column-1] == 'o')
					{
						aliveCount++;
					}
				}
				if(row != 0 && column != board[row].length-1)
				{
					if(board[row-1][column+1] == 'o')
					{
						aliveCount++;
					}
				}
				if(row != board.length-1)
				{
					if(board[row+1][column] == 'o')
					{
						aliveCount++;
					}
				}
				if(row != board.length-1 && column != 0)
				{
					if(board[row+1][column-1] == 'o')
					{
						aliveCount++;
					}
				}
				if(row != board.length-1 && column != board[row].length-1)
				{
					if(board[row+1][column+1] == 'o')
					{
						aliveCount++;
					}
				}
				if(column != board[row].length-1)
				{
					if(board[row][column+1]== 'o')
					{
						aliveCount++;
					}
				}
				
				if((aliveCount < 2) || (aliveCount > 3))
				{
					tempArray[row][column] = ' ';
				}
				else if(aliveCount == 3)
				{
					tempArray[row][column] = 'o';
				}
				else if(aliveCount == 2)
				{
					tempArray[row][column] = board[row][column];
				}
			}
		}
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				board[row][column] = tempArray[row][column];
			}
		}
	}
}
