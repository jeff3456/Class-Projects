/*Author: Jefferson Lee
 * Date: 4/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class Bucket 
{
	private String garbage;
	
	public Bucket()
	{
		this.garbage = "";
	}
	
	public void dumpIngredient(char ingredient)
	{
		this.garbage += ingredient;
	}
	public String toString()
	{
		return garbage;
	}
	public int getSize()
	{
		return garbage.length();
	}
}
