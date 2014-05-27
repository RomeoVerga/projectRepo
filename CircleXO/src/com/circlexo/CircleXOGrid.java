package com.circlexo;
import java.lang.reflect.Constructor;

/**
 *This object manages the game board in regards to setting players moves and checking if a player wins.
 *
 * @version 1.0.0
 */
public class CircleXOGrid {
	private char[][] field;
	private Queue queue;

	//----------Constants----------//
	public final int MAX_FIELD_LENGTH = 8;
	public final int MAX_FIELD_WIDTH = 4;
	public final char X_PLAYER = 'X';
	public final char O_PLAYER = 'O';
	public final char EMPTY	= '*';

	private char currPlyr;
	private char winner;

	/**
	 * {@link Constructor}
	 * 
	 * Creates Object with X starting (default)
	 * 
	 * @param xStarting
	 * 	Determines if Player X will start first. true - X starts, false - O starts.
	 */
	public CircleXOGrid(boolean xStarting)
	{
		if(xStarting)	currPlyr = X_PLAYER;
		else			currPlyr = O_PLAYER;

		initializeField();
		
		queue = new Queue();
	}
	
	/**
	 *{@link Constructor}
	 *
	 *Creates Object with X starting (default)
	 */
	public CircleXOGrid()
	{
		currPlyr = X_PLAYER;
		
		initializeField();
	}

	private void initializeField()
	{
		field = new char[MAX_FIELD_LENGTH][MAX_FIELD_WIDTH];

		for(int j = 0; j < MAX_FIELD_WIDTH; j++)
		{
			for(int i = 0; i < MAX_FIELD_LENGTH; i++)
			{
				field[i][j] = EMPTY;
			}
		}
		
		winner = EMPTY;
	}
	
	public char getWinner()		{return winner;}
	
	public int[] getXList()		// implement throw exceptions *****TODO*****
	{
		int[] out = null;
		
		if(winner != EMPTY)
		{
			out = queue.getXList();
		}
		
		return out;
	}
	
	public int[] getYList()		// implement throw exceptions *****TODO*****
	{
		int[] out = null;
		
		if(winner != EMPTY)
		{
			out = queue.getYList();
		}
		
		return out;
	}
	
	public char getCurrPlyr()	{return currPlyr;}
	
	public char getPrevPlyr()	{if(currPlyr == X_PLAYER) return O_PLAYER;	
								 else					  return X_PLAYER;}
	
	public boolean playPos(int x,int y)
	{
		boolean validMove = false;
		
		if(field[x][y] == EMPTY && winner == EMPTY)
		{
			field[x][y] = currPlyr;
			
			updateWinner(x,y);
			
			if(currPlyr == X_PLAYER)	currPlyr = O_PLAYER;
			else						currPlyr = X_PLAYER;
			
			validMove = true;
		}
		
		return validMove;
	}
	
	/**
	 * This checks if the player wins horizontally, diagonally(both), and vertically
	 * @param x
	 * 	The x position on the grid.
	 * @param y
	 * 	The y position on the grid.
	 */
	private void updateWinner(int x,int y)
	{
		if(chkHoriz(x,y) >= 4) 			winner = currPlyr;
		else if(chkFwdDiag(x,y) >= 4)	winner = currPlyr;
		else if(chkBwdDiag(x,y) >= 4)	winner = currPlyr;
		else if(chkVert(x,y)    >= 4)	winner = currPlyr;
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++  START OF HELPER METHODS  ++++++++++++++++++++++++++++++++++++++++++++++//
	
	private int chkVert(int x,int y)
	{
		int count = 0;
		
		for(int j = 0; j < MAX_FIELD_WIDTH && field[x][j] == currPlyr;j++)
		{
			count++;
		}
		
		return count;
	}
	
	
	private int chkHoriz(int x,int y)
	{
		int count = 0;
		
		for(int i = 0; i <= 3 && field[(x+i)%MAX_FIELD_LENGTH][y] == currPlyr; i++)
		{
			count++;
		}
			
		for(int i = -1; i >= -3 && field[Math.abs((x+i)%MAX_FIELD_LENGTH)][y] == currPlyr; i--)
		{
			count++;
		}
		
		
		return count;
	}
	
	private int chkFwdDiag(int x,int y)
	{
		int count = 0;
		
		for(int i = 0 ; (y+i) < MAX_FIELD_WIDTH && field[((x+i)%MAX_FIELD_LENGTH)][y+i] == currPlyr; i++)
		{
			count++;
			queue.add(((x+i)%MAX_FIELD_LENGTH),y+i);
		}
		
		for(int i = -1 ; (y+i) >= 0 && field[Math.abs((x+i)%MAX_FIELD_LENGTH)][y+i] == currPlyr; i--)
		{
			count++;
		}
		
		return count;
	}

	
	private int chkBwdDiag(int x,int y)
	{
		int count = 0;
		
		for(int i = 0 ; (y+i) < MAX_FIELD_WIDTH && field[Math.abs((x-i)%MAX_FIELD_LENGTH)][y+i] == currPlyr; i++)
		{
			count++;
		}
		
		for(int i = -1 ; (y+i) >= 0 && field[((x-i)%MAX_FIELD_LENGTH)][y+i] == currPlyr; i--)
		{
			count++;
		}
		
		
		return count;
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++  END OF HELPER METHODS  ++++++++++++++++++++++++++++++++++++++++++++++++//
	
	public String toString()
	{
		String out = "";
		
		for(int j = 0; j < MAX_FIELD_WIDTH;j++)
		{
			for(int i = 0; i < MAX_FIELD_LENGTH;i++)
			{
				out += field[i][j] + " ";
			}
			out += "\n";
		}
		
		if(winner != EMPTY) out += "WINNER IS" + winner + "\n";
		
		return out;
	}
	
}
