import java.util.ArrayList;


public class StringMatch 
{
	public static void main(String[] args)
	{
		String s = "hw2.java Account.java, ATM.java";
		System.out.println(java2class(s));
		
	}
	public static String java2class(String s)
	{
		ArrayList<Character> classMod = new ArrayList<Character>();
		while(s.contains(".java"))
		{
			// add in all the characters in the string to ArrayList
			for(int i = 0; i < s.length(); i++)
			{
				classMod.add(s.charAt(i));
			}
			// check if .java is in the string
			// then insert .class where .java was
			int size = classMod.size();
			for(int i = 0; i < size; i++)
			{
				//checking if '.' is in ArrayList and if there are 4 spots left afterwards.
				if(classMod.get(i) == '.' && (size - i >= 5))
				{
					// check if it spells ".java"
					if(classMod.get(i+1) == 'j' && classMod.get(i+2) == 'a' && classMod.get(i+3) == 'v' && classMod.get(i+4) == 'a')
					{
						// start replacing the letters "java" to "clas"
						classMod.set(i+1, 'c');
						classMod.set(i+2, 'l');
						classMod.set(i+3, 'a');
						classMod.set(i+4, 's');
						// must add this element because you cannot replace next character
						classMod.add(i+5, 's');
						i += 6;
					}
				}
				size = classMod.size();
			}
			
			//finally make the ArrayList a string by adding all the elements to finalS then return it
			String finalS = "";
			for(int i =  0; i < classMod.size(); i++)
			{
				finalS = finalS + classMod.get(i);
			}
			return finalS;
		}
		return null;
	}
}
