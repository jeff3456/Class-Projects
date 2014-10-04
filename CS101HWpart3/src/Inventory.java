/*Author: jefferson lee
 * Date: April 28 2014
 * Class: CS101 Spring 2014 section 3
 */
import java.util.ArrayList;


public class Inventory 
{
	ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
	
	public void add(String title, double rating, int year)
	{
		int movieAdd = 0;
		for(int i = 0; i < listOfMovies.size(); i++)
		{
			Movie a = listOfMovies.get(i);
			if(a.title.equals(title) && a.year == year)
			{
				a.quantity++;
				movieAdd++;
				
				break;
			}
		}
		if(movieAdd == 0)
		{
			Movie temp = new Movie(title, year, rating);
			listOfMovies.add(temp);
		}
	}
	
	public void remove(String title, int year)
	{
		for (int i = 0; i < listOfMovies.size(); i++)
		{
			Movie a = listOfMovies.get(i);
			if (a.title.equals(title) && a.year == year)
			{
				if(a.quantity > 1)
				{
					a.quantity--;
					listOfMovies.add(i,a);
				}
				else
				{
					listOfMovies.remove(i);
				}
			}
		}
	}
	
	@Override
	public String toString()
	{
		System.out.printf("%-45s %-8s %-8s %-8s \n", "Title", "Year", "Rating", "Quantity");
		String temp = "";
		for( int i = 0; i < listOfMovies.size(); i++)
		{
			temp += String.format("%-45s %-8s %-8s %-8s \n", listOfMovies.get(i).title,listOfMovies.get(i).year,listOfMovies.get(i).rating,listOfMovies.get(i).quantity);
		}
		return temp;
	}
}
