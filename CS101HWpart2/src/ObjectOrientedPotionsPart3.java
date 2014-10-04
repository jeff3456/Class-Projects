/*Author: Jefferson Lee
 * Date: 4/5/2014
 * Section: CS101, Section 03, Spring 2014
 */
public class ObjectOrientedPotionsPart3 
{
	public static void main(String [] args)
	{
		potions a = new potions(5);
		Bucket b = new Bucket();
		String itemsToMix = "brcaxpaxdqaqdrrdtpaxxdbapp"
				+ "rbbpqaqaqqpacbxcaaprrardawpaccrxpabqqqqw"
				+ "cpqpxdawrpbadddddqppcaccbxdpbbpxwqqrcrbarraqq"
				+ "xpabrrbcrqpbbcxbbprqacbxbwaccpbrqadxpqdwrqawwdr"
				+ "cpwcqpqawpabrcqqxdabpbbbcppwpbxbdbbrbbcwaxrqxqcqdqpa"
				+ "pwdcdadawxaxprrdxaqpbcpqcpdqbpwwwcxdwcardcxcbcx"
				+ "xwwaqrcdxpwpdpaqrabwqddqqdqqpbarqqdqqcaddwwabda"
				+ "braxxpabqxrabrxdqqcaxaaxxaxqqbrcrracxwdqxxxwxbwdcwcp"
				+ "xrrrddcdxxdbwrwxppcpxcrxdxqrcqpawppcdqppbxbqbqawqwqcpc"
				+ "qapcwwawbrpqbpqcqxrrcarpbqqqacxadbararrxaawpqqacqprccrd"
				+ "qpraawcaabrqqrqqwbwdwqqdaqcqdqparbb";
		for(int i = 0; i < itemsToMix.length(); i++)
		{
			if(a.isFull())
			{
				if(a.heatPotion())
				{
					break;
				}
				a.discardPotion(b);
			}
			a.addIngredient(itemsToMix.charAt(i), b);
		}
		System.out.println("The successful potion is: " + a.toString());
		System.out.println("The bucket contains: " + b.toString());
	}
}
