
public class Pokemon 
{
	String name;
	char type;
	
	public Pokemon(String n, char t)
	{
		this.name = n;
		this.type = t;
	}
	
	public int battle(Pokemon otherGuy)
	{
		if ((this.type =='f' && otherGuy.type =='g') || 
				(this.type =='g' && otherGuy.type == 'w') || 
				(this.type == 'w' && otherGuy.type =='f'))
		{
			return 1;
		}
		else if (this.type == otherGuy.type)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
