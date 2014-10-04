/* Author: Jefferson Lee
 * Date: 3/27/2014
 * Section: CS101 section 3 Spring 2014
 */
public class CodeTimer 
{
	long startTime;
	long endTime;
	
	public CodeTimer()
	{
		this.startTime = System.currentTimeMillis();
	}
	
	public long getStartTime()
	{
		long mseconds = System.currentTimeMillis();
		return mseconds;
	}
	public long getEndTime()
	{
		long mseconds = System.currentTimeMillis();
		return mseconds;
	}
	public void start()
	{
		this.startTime = System.currentTimeMillis();
	}
	public void stop()
	{
		this.endTime = System.currentTimeMillis();
	}
	public double getElapsedTime()
	{
		double elapsedTime = (endTime - startTime)/1000.;
		return elapsedTime;
	}
}
