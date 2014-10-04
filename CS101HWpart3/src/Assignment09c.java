/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
import processing.core.PApplet;


public class Assignment09c extends PApplet
{
	int numCircles = 100;
	int [] x = new int [numCircles];
	int [] y = new int [numCircles];
	int counter = 0;
	int num = 0;
	public void setup()
	{
		size(500,500);
		background(0);
	}
	public void draw()
	{
		background(0);
		x[counter] = mouseX;
		y[counter] = mouseY;
		if (counter < 99)
		{
			counter++;
		}
		else
		{
			counter = 0;
		}
		
		if( num < 100)
		{
			num++;
		}
		for(int i = 0; i < num; i++)
		{
			int r = (int) random(0,255);
			int g = (int) random(0,255);
			int b = (int) random(0,255);
			fill(r,g,b);
			ellipse(x[i], y[i], 30,30);
		}
		

	}
}
