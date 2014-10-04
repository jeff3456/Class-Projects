/* Jefferson Lee
 * 9/13/2014
 * Data Structures section 1
 * 
 * How to decrease probability of bad names?
 * 
*/

import java.util.*;

/* digraphs: {"bl", "br", "ch","cl", "cr","dr","fl","fr","gl","gr",
				"kn","ph","pl","pr","sc","sh", "sk","sl","sm","sn","sp","st","sw","th",
				"tr","wh","wr"}
 * dipthongs: {"oi","ai","ae","io","ie","ia","ua","ue","au","eu","iu",
					"ui","ou","oa"}
 * t-consonants: {"ch", "ck","ph","sh", "sk","sm","sp","st","th","ng"}
 * My three cultured names: 1) American: names are usually 1 or 2 syllables. Last syllable has a constant.
 * 2) Korean: Names are always 3 syllables separated by space. The surname comes first. The 3 syllables
 * 		are comprised of typical Korean syllables as shown by the givenName1[] and givenName2[] arrays.
 * 3) Italian: Names are usually 3 or 4 syllables. Names end in a typical Italian vowel such as ia or io.
 * 		Italian names also have a specific t-consonant called tItalian[]
 */

//Note: my t-Consonant method is simple a randomConsonant method that takes an integer
// as an argument. With no arguments it is simply a randomConsonant generator.

public class Zoombinis {

	public static void main(String[] args) 
	{
		Random numGenerator;
		int numZoombinis = 16;
		int culture = 1;
		
		// check if there is an argument for each parameter by checking the number of arguments
		if(args.length > 0)
		{
			numGenerator = new Random(Long.parseLong(args[0]));
		}
		else
		{
			numGenerator = new Random(0);
		}
		if(args.length > 1)
		{
			numZoombinis = Integer.parseInt(args[1]);
		}
		
		if(args.length > 2)
		{
			culture = Integer.parseInt(args[2]);
		}
		
		for(int i = 0; i < numZoombinis; i++)
		{
			System.out.println(randomName(culture));
		}
	}
	
	
	// different Character methods
	// Character.isLetter(c); | isLowerCase(c), isUpperCase(c), toUpper(c), and toLower(c)
	
	// is vowel method checks if the character is a vowel.
	public static boolean isVowel(char c)
	{
		c = Character.toLowerCase(c);
		if(c == 'o' || c == 'a' || c == 'e' || c == 'i' || c == 'u')
		{
			return true;
		}
		return false;
	}
	
	// is consonant method check if the character is a consonant
	public static boolean isConsonant(char c)
	{
		c = Character.toLowerCase(c);
		
		// check if it is not a vowel and then check if it is in the range of the ASCII values
		if(!isVowel(c) && (c > 96) && (c < 123))
		{
			return true;
		}
		return false;
	}
	
	// use a switch statement and random number to generate random vowel
	public static String randomVowel()
	{
		// Math.random produces a double that includes 0 and is less than 1
		int random = (int)(6*Math.random());
		String c = "a";
		switch (random)
		{
		case 0: 
			c = "a";
			break;
		case 1: 
			c = "e";
			break;
		case 2: 
			c = "i";
			break;
		case 3: 
			c = "o";
			break;
		case 4: 
			c = "u";
			break;
		// this is the extra case where the vowel could take the form of a dipthong
		case 5:
			String[] dipthongs = {"oi","ai","ae","io","ie","ia","ua","ue","au","eu","iu",
					"ui","ou","oa"};
			random = (int)(dipthongs.length * Math.random());

			c = dipthongs[random];
			break;
		}
		
		return c;
	}
	
	// uses the random number generation and isVowel method to return a consonant
	// this is the first consonant method, not the t-consonant.
	public static String randomConsonant()
	{
		String c = "a";
		String[] digraphs = {"bl", "br", "ch","cl", "cr","dr","fl","fr","gl","gr",
				"kn","ph","pl","pr","sc","sh", "sk","sl","sm","sn","sp","st","sw","th",
				"tr","wh","wr"};
		//calling the isVowel function in the while loop until it is false
		// meaning there is a consonant stored in c
		while(isVowel(c.charAt(0)))
		{
			// Math.random is multiplied by 33 to account for the chance of a digraph
			int random = (int) (97 + Math.random() * 33);
			
			// if the random is greater than the char z value, 
			// then a random digraph is set equal to c
			if(random > 122)
			{
				random = (int)(27 * Math.random());
				c = digraphs[random];
			}
			else
			{
				c = "" + (char) random;
			}
		}
		return c;
	}

	
	// this is the overloaded method when you include a t-consonant
	public static String randomConsonant(int a)
	{
		String c = "a";
		String[] tDigraphs ={"ch", "ck","ph","sh", "sk","sm","sp","st","th","ng"};
		String[] tItalian = {"ll","m","tt","n","f","c","st","ss","s","t","v"};
		
		if(a == 3)
		{
			int random = (int)(tItalian.length * Math.random());
			return tItalian[random];
		}
		
		
		//calling the isVowel function in the while loop until it is false
		// meaning there is a consonant stored in c
		while(isVowel(c.charAt(0)))
		{
			// Math.random is multiplied by 33 to account for the chance of a digraph
			int random = (int) (97 + Math.random() * 33);
			
			// if the random is greater than the char z value, 
			// then a random digraph is set equal to c
			if(random > 122)
			{
				random = (int)(tDigraphs.length * Math.random());
				c = tDigraphs[random];
			}
			else
			{
				c = "" + (char) random;
			}
		}
		return c;
	}
	
	// returns a random consonant and vowel to create a syllable
	public static String randomSyllable()
	{
		String a = "" + randomConsonant() + randomVowel();
		if(Math.random() > .5)
		{
			a = a + randomConsonant(1);
		}
		return a;
	}
	
	// produces a random name using switch function to account for probability of different name
	
	//overloaded method that takes into account the culture of a name
	public static String randomName(int culture)
	{
		
		// This first tempS is required to make sure the first letter of the name is capitalized
		String tempS = randomConsonant();
		// checks if the consonant is a digraph. Then changes the first letter to an uppercase
		if(tempS.length() > 1)
		{
			tempS = "" + Character.toUpperCase(tempS.charAt(0)) + tempS.charAt(1);
		}
		else
		{
			tempS = "" + Character.toUpperCase(tempS.charAt(0));
		}
		
		// String a is the name that will be returned by default
		String a = "";
		
		if(Math.random() > .5 && culture != 3)
		{
			a = "" + tempS + randomVowel();

		}
		else
		{
			a = "" + tempS + randomVowel() + randomConsonant(culture);
		}
		// American (default) names
		if (culture == 1)
		{
			String name = "";
			int nameLength = 1;
			double random = Math.random();
			if(random > 0.5)
			{
				nameLength = 2;
			}
			
			for(int i = 0; i < nameLength; i++)
			{
				if(i == 0)
				{
					name = tempS + randomVowel();
				}
				else
				{
					name = name + randomConsonant() + randomVowel();

				}
				
				if(i == nameLength - 1)
				{
					name = name + randomConsonant(1);
				}
			}
			return name;
		}
		
		// Korean names: built of 3 syllables. Korean names are very formulaic and can be derived using
		// common syllables. givenName1 contains the first syllable, givenName2 contains the second
		// and surName is the last name.
		else if(culture == 2)
		{
			String name = "";
			int nameLength = 3;
			String[] surName = {"Kim ", "Lee ","Park ","Chung ","Kang ","Go ","Bae ","Seo ","Sim ",
					"Im ","Jang ","Jeon ","Cho ","Chon ","Chang ","Han ","Hong "};
			String[] givenName1 = {"Kwang ", "Kyu ", "Dong ", "Nam ","Da ","Myung ","Mi ","Mun ","Sang ",
					"Seung ","Shin ","Soon ","Woo ","Yoo ","Young ","Eun ","Ha ","Jae ","Jung ","Joon ",
					"Tae ","Hee "};
			String[] givenName2 = {"Kyung", "Geun","Gi","Mi","Min","Bin","Yeon","Won","Eun",
					"Chul","Hwan","Hwa","Hoon"};
			String surNameTemp = surName[(int) (Math.random() * surName.length)];
			String koreanName = givenName1[(int) (Math.random() * givenName1.length)]; 
			String koreanName1 = givenName2[(int) (Math.random() * givenName2.length)];
			
			name = surNameTemp + koreanName + koreanName1;
			return name;
			
		}
		
		// Italian names
		else if(culture == 3)
		{
			String[] italianVowels = {"a", "o","ia","i","io","eo", "e",};
			
			if(Math.random() > .5)
			{
				for(int i = 0; i < 2; i++)
				{
					a = a + italianVowels[(int)(Math.random() * italianVowels.length)] + randomConsonant(culture);
				}
				a = a + italianVowels[(int)(Math.random() * italianVowels.length)];
			}
			else
			{
				for(int i = 0; i < 1; i++)
				{
					a = a + italianVowels[(int)(Math.random() * italianVowels.length)] + randomConsonant(culture);
				}
				a = a + italianVowels[(int)(Math.random() * italianVowels.length)];
			}
			return a;
		}
		
		
		
		// using Math.random() to generate random integers from 0 to 9
		// this is the default back up name generator in case the culture wasn't
		// identified
		int length = (int) (10 * Math.random());

		switch(length)
		{
		case 0: 
			for(int i = 0; i < 0; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 1:
			for(int i = 0; i < 1; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 2:
			for(int i = 0; i < 1; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 3:
			for(int i = 0; i < 1; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 4:
			for(int i = 0; i < 2; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 5:
			for(int i = 0; i < 2; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 6:
			for(int i = 0; i < 2; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 7:
			for(int i = 0; i < 3; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 8:
			for(int i = 0; i < 3; i++)
			{
				a = a + randomSyllable();
			}
			break;
		case 9:
			for(int i = 0; i < 4; i++)
			{
				a = a + randomSyllable();
			}
			break;
		}

		return a;
	}
	
}
