/* Author: Jefferson Lee
 * Date: 3/27/2014
 * Section: CS101 section 3 Spring 2014
 */
public class City 
{
	String name;
	double lon;
	double lat;
	
	public City(String namee, double lonn, double latt)
	{
		name = namee;
		lon = lonn;
		lat = latt;
	}
	
	public City()
	{
		name = "Atlantis";
		lon = 0;
		lat = 0;
	}
	
	public void report()
	{
		System.out.println("City: " + name + " is at: " + lon + ", " + lat);
	}
	public double distanceFrom(City otherCity)
	{
		double lonDiff = lon - otherCity.lon;
		double latDiff = lat - otherCity.lat;
		double distance = Math.pow(Math.pow(lonDiff, 2) + Math.pow(latDiff,2),.5);
		return distance;
	}
}
