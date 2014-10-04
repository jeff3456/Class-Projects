/*Author: Jefferson Lee
 * Date: 5/3/2013
 * Section: CS101, section 03, Spring 2014
 */
import processing.core.PApplet;

public class Part1 extends PApplet
{
	public Shape shape01;
	public Shape shape02;
	
	public void setup()
	{
		// size the canvas at 400x400 pixels
		size(400,400);

		// create a new Shape w/ color r=90, g=13, b=11
		this.shape01 = new Shape("trunk");
		this.shape01.setColor(90, 13, 11);
		
		// coordinates for shape #1
		// format:  x1,y1,x2,y2, ... ,xN,yN
		String sourceImage01 = "151,263,151,322,120,383,169,374,213,395,214,376,247,378,219,344,222,261";

		// split up the raw data
		String[] splitData01 = sourceImage01.split(",");
		
		// create a series of points based off the data
		for (int i = 0; i < splitData01.length; i+=2)
		{
			// parse into floats
			float x = Float.parseFloat(splitData01[i]);
			float y = Float.parseFloat(splitData01[i+1]);
			
			// create a point
			Point temp = new Point(x,y);
			
			// add point to our shape
			shape01.addPoint( temp );
		}
		
		
		// create a new Shape w/ color r=6, g=150, b=0
		this.shape02 = new Shape("branches");
		this.shape02.setColor(6, 150, 0);
		
		// coordinates for shape #2
		// format:  x1,y1,x2,y2, ... ,xN,yN
		String sourceImage02 = "202,3,297,39,312,100,352,140,317,178,288,233,224,262,150,263,85,239,48,183,9,146,8,102,42,56,113,38";
		
		// split up the raw data
		String[] splitData02 = sourceImage02.split(",");
		
		// create a series of points based off the data
		for (int i = 0; i < splitData02.length; i+=2)
		{
			// parse into floats
			float x = Float.parseFloat(splitData02[i]);
			float y = Float.parseFloat(splitData02[i+1]);

			// create a point
			Point temp = new Point(x,y);
			
			// add point to our shape
			shape02.addPoint( temp );
		}		

		// draw the shapes
		shape01.draw(this);
		shape02.draw(this);
	}
	
	// animation loop - not needed for this method since
	// we did all of our drawing in setup()
	public void draw()
	{
	}
}
