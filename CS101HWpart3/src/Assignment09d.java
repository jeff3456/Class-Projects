/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
import javax.swing.JOptionPane;

import processing.core.PApplet;


public class Assignment09d extends PApplet
{
	int numBalls;
	Ball [] a;

	public void setup()
	{
		numBalls = Integer.parseInt(JOptionPane.showInputDialog(null,"How many balls?" ,"Input number", JOptionPane.QUESTION_MESSAGE));
		size(500,500);
		a = new Ball[numBalls];
		for(int i = 0; i < numBalls; i ++)
		{
			a[i] = new Ball();
		}
	}
	
	public void draw()
	{
		background(0);
		for(int i = 0; i < numBalls; i++)
		{
			if(a[i].active)
			{
				fill(a[i].r,a[i].b, a[i].g);
				ellipse((int)a[i].xPos,(int) a[i].yPos, (int) a[i].size,(int) a[i].size);
				a[i].move();
				a[i].checkHit(mouseX, mouseY);
			}
		}
	}
}
