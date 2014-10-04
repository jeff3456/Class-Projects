/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
import processing.core.PApplet;


public class Assignment09b extends PApplet
{
	int a,b,c,d;
	public void setup()
	{
		size(500,500);
		background (150);
		fill(0,0,0);
		rect(0,0,250,250);
		rect(250,250,250,250);
		rect(250,0,250,250);
		rect(0,250,250,250);
		
	}
	public void draw()
	{
		if(mouseX < 250 && mouseY < 250)
		{
			a = 255;
		}
		else if(mouseX < 250 && mouseY < 500)
		{
			b = 255;
		}
		else if (mouseX < 500 && mouseY <250)
		{
			c = 255;
		}
		else if(mouseX < 500 && mouseY < 500)
		{
			d = 255;
		}
		fill(a,a,a);
		rect(0,0,250,250);
		fill(b,b,b);
		rect(0,250,250,250);
		fill(c,c,c);
		rect(250,0,250,250);
		fill(d,d,d);
		rect(250,250,250,250);


		
		if(a > 0)
		{
			a--;
		}
		if(b > 0)
		{
			b--;
		}
		if(c > 0)
		{
			c--;
		}
		if(d > 0)
		{
			d--;
		}

	}
}
