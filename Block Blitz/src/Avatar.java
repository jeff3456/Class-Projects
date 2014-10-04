
public class Avatar 
{
	float xPos;
	float yPos;
	
	public Avatar(float x, float y)
	{
		xPos = x;
		yPos = y;
	}
	
	public void moveLeft()
	{
		xPos ++;
	}
	public void moveRight()
	{
		xPos --;
	}
	public void moveUp()
	{
		yPos --;
	}
	public void moveDown()
	{
		yPos ++;
	}
}
