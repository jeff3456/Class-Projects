/* Author: Jefferson Lee
 * Date: 03/24/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Rectangle 
{
	double width;
	double height;
	double xPos;
	double yPos;
	public Rectangle(double widthh, double heightt, double xPosition, double yPosition)
	{
		this.width = widthh;
		this.height = heightt;
		this.xPos = xPosition;
		this.yPos = yPosition;
	}
	public Rectangle()
	{
		width = 1.0;
		height = 1.0;
		xPos = 0;
		yPos = 0;
	}
	public double getArea()
	{
		return (width * height);
	}
	public double getPerimeter()
	{
		return (width + width + height + height);
	}
}
