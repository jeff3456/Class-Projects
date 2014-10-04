/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
import processing.core.PApplet;


public class Ball extends PApplet
{
	double xPos;
	double yPos;
	double xSpeed;
	double ySpeed;
	int xDirection = 1;
	int yDirection = 1;
	double size;
	int r;
	int g;
	int b;
	boolean active = true;
	static int numInactive = 0;
	
	public Ball()
	{
		xPos = random(10,490);
		yPos = random(10,490);
		xSpeed = random(1,4);
		ySpeed = random(1,4);
		size = random(10, 50);
		r = (int) random(0,255);
		g = (int) random(0,255);
		b = (int) random(0,255);
		if(random(0,1) > .5)
		{
			xDirection *= -1;
		}
		if(random(0,1) > .5)
		{
			yDirection *= -1;
		}
	}
	public void move()
	{
		if(active)
		{
			if(xPos > 500 || xPos < 0)
			{
				xDirection *= -1 ;
			}
			if(yPos > 500 || yPos < 0)
			{
				yDirection *= -1;
			}
			xPos += xSpeed * xDirection;
			yPos += ySpeed * yDirection;
		}
		else
		{
			r = 0;
			b = 0;
			g = 0;
		}
	}
	public void checkHit(int x, int y)
	{
		if(size/2 >= Math.pow(Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2), .5))
		{
			active = false;
			numInactive++;
		}
		
	}
}
