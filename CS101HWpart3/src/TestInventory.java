
public class TestInventory 
{
	public static void main(String[] args)
	{
		Inventory a = new Inventory();

		a.add("Happy Gilmore", 3.5, 1996);
		a.add("Star Wars", 4.8, 1977);
		a.add("Return of the Jedi", 3.9, 1983);
		a.add("The Nightmare Before Christmas", 5.0, 1993);
		a.add("Return of the Jedi", 3.9, 1983);

		System.out.println(a.toString() );

		a.remove("Return of the Jedi", 1983);

		System.out.println(a.toString() );

		a.remove("The Nightmare Before Christmas", 1993);

		System.out.println(a.toString() );
	}
}
