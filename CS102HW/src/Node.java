
public class Node 
{
	public String value;
	public Node next;
	public Node(String s)
	{
		value = s; 
		next = null; 
	}
	public Node()
	{
		value = Zoombinis.randomName(1); 
		next = null;
	}
}
