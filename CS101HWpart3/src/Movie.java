/*Author: jefferson lee
 * Date: April 28 2014
 * Class: CS101 Spring 2014 section 3
 */
public class Movie 
{
	public String title;
	public int year;
	public double rating;
	public int quantity = 1;
	
	public Movie(String title, int year, double rating, int quantity)
	{
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.quantity = quantity;
	}
	public Movie(String title, int year, double rating)
	{
		this.title = title;
		this.year = year;
		this.rating = rating;
	}
}
