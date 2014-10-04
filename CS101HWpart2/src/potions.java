/*Author: Jefferson Lee
 * Date: 4/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class potions 
{
	private int numIng;
	private String ingredients;
	
	public potions()
	{
		this.numIng = 10;
		this.ingredients = "";
	}
	public potions(int numberIng)
	{
		numIng = numberIng;
		ingredients = "";
	}
	
	public boolean addIngredient(char ingredient, Bucket b)
	{
		if((this.ingredients.length() < numIng) && ((ingredient == 'a')
				|| (ingredient == 'b')
				|| (ingredient == 'c')
				|| (ingredient == 'd')
				|| (ingredient == 'w')))
		{
			this.ingredients += ingredient;
			return true;
		}
		if((ingredient != 'a')
				|| (ingredient != 'b')
				|| (ingredient != 'c')
				|| (ingredient != 'd')
				|| (ingredient != 'w'))
		{
			b.dumpIngredient(ingredient);
		}
		return false;
	}
	
	public boolean heatPotion()
	{
		
		String temp = "";
		for(int i = 0; i < this.ingredients.length(); i++)
		{
			if(this.ingredients.charAt(i) != 'w')
			{
				temp += this.ingredients.charAt(i);
			}
		}
		if(this.ingredients.length() == temp.length())
		{
			return false;
		}
		else
		{
			this.ingredients = temp;
			return true;
		}
	}
	
	public void discardPotion(Bucket b)
	{
		if(heatPotion())
		{
			
		}
		else
		{
			for(int i = 0; i < this.ingredients.length(); i++)
			{
				b.dumpIngredient(this.ingredients.charAt(i));
			}
			this.ingredients = "";
		}
	}
	
	public String toString()
	{
		return this.ingredients;
	}
	public boolean isFull()
	{
		if(this.ingredients.length() >= numIng)
		{
			return true;
		}
		return false;
	}

}
