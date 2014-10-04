/* Author: Jefferson Lee
 * Date: 3/27/2014
 * Section: CS101 section 3 Spring 2014
 */
public class Assignment07a {

	public static void main(String[] args) 
	{
		Rectangle a = new Rectangle(10, 10, -5, 5);
		Rectangle b = new Rectangle(10, 20, -5, 10);

		System.out.println("Rectangle #1");
		System.out.println("width & height = " + a.width + " x " + a.height);
		System.out.println("coordinates = " + a.xPos + " , " + a.yPos);
		System.out.println("area: " + a.getArea());
		System.out.println("perimeter: " + a.getPerimeter());
		System.out.println();
		System.out.println("Rectangle #2");
		System.out.println("width & height = " + b.width + " x " + b.height);
		System.out.println("coordinates = " + b.xPos + " , " + b.yPos);
		System.out.println("area: " + b.getArea());
		System.out.println("perimeter: " + b.getPerimeter());

	}

}
