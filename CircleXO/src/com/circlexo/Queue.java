package com.circlexo;

public class Queue {
	private int[] queueX,queueY;
	private final int MAX_SIZE = 4;
	private boolean fullQ;
	private int front;
	
	public Queue()
	{
		queueX = new int[MAX_SIZE];
		queueY = new int[MAX_SIZE];
		fullQ = false;
		front = 0;
	}
	
	public void add(int x, int y)
	{
		queueX[front] = x;
		queueY[front] = y;
		
		if(front == 3) fullQ = true;	//indicate full queue
		
		front = (front+1)%MAX_SIZE;		//front must be reset to 0; to prevent overflow from clicking
	}
	
	public int[] getXList()		//throw Exceptions must be implemented *****TODO*****
	{
		int[] out = null;
		
		if(fullQ)
		{
			out = new int[MAX_SIZE];
			System.arraycopy(queueX, 0, out, 0, MAX_SIZE);
		}
		
		return out;
	}
	
	public int[] getYList()		//throw Exceptions must be implemented *****TODO*****
	{
		int[] out = null;
		
		if(fullQ)
		{
			out = new int[MAX_SIZE];
			System.arraycopy(queueY, 0, out, 0, MAX_SIZE);
		}
		
		return out;
	}
}
