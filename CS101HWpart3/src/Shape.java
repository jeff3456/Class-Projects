import java.util.ArrayList;

import processing.core.PApplet;

/* Author: Jefferson Lee
 * Date: 5/3/2013
 * Section: CS101, section 03, Spring 2014
 */
public class Shape extends PApplet
{
	protected String name;
	protected float red;
	protected float green;
	protected float blue;
	protected ArrayList<Point> Points;

	// Constructor that initializes name and arraylist
	public Shape (String name)
	{
		this.name = name;
		Points = new ArrayList<Point>();
	}
	
	//A method called setColor which sets the color
	public void setColor(float r, float g , float b)
	{
		red = r;
		green = g;
		blue = b;
	}
	
	//A method that adds a point to the Shape's ArrayList
	public void addPoint(Point P)
	{
		Points.add(P);
	}
	//A getter for the name of the shape
	public String getName()
	{
		return name;
	}
	
	//getter for number of POints in the Shape
	public int getNumPoints()
	{
		return Points.size();
	}
	
	//A method that draws the Shape to a graphical canvas
	public void draw(PApplet canvas)
	{
		// begin by setting our fill color
	   canvas.fill(this.red, this.green, this.blue);

	   // turn off the edge stroke
	   canvas.noStroke();

	   // start drawing a shape
	   canvas.beginShape();
			
	   // use the vertex method to lay down a point
	   // you will need to do this for each point in the shape
	   for( int i = 0; i < Points.size(); i++)
	   {
		   canvas.vertex( Points.get(i).x, Points.get(i).y );
	   }
	   // end the shape
	   canvas.endShape(canvas.CLOSE);
	}
}
