/* Author: Jefferson Lee
* Date: 03/23/2014
* Section CS101, Section 03 Spring 2014
*/
import processing.core.PApplet;


public class GameOfLifeGraphicsTemplate extends PApplet
{
	char[][] theBoard;
	
	
	public void setup()
	{
		theBoard = new char[50][50];
		
		clearBoard(theBoard);
		
		randomizeBoard(theBoard, .12);		
		
		size(500, 500);
		
		frameRate(3);
	}
	
	public void draw()
	{
		background(0);
		
		drawBoard(theBoard);
		
		runGame(theBoard);
	}
	
	public void drawBoard(char[][] board)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[row].length; col++)
			{
				if (board[row][col] == 'o')
				{
					fill(165, 165, 165);
				}
				else
				{
					fill(255,255,255); // white
				}
		
				int cellSize = width / board[row].length;
				
				int xPosition = cellSize * col;
				int yPosition = cellSize * row;
				
				rect(xPosition, yPosition, cellSize, cellSize);				
			}
		}
	}
	
	public void randomizeBoard(char[][] board, double chance)
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
}
