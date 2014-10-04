
public class inclassstuff {

	public static void main(String[] args) 
	{
		int[] mylist = {323, 331, 323, 336, 319, 330, 322};
		String word = "treasurelieswithinthischest";
		int sum = 0;
		for (int i = 0 ; i < word.length();i++)
		{
			sum += word.charAt(i) - 97;
		}
		int temp = 0;
		for (int i = 0; i < mylist.length; i++)
		{
			mylist [i] = mylist[i] - sum;
		}
		for (int i = 0; i < mylist.length; i++)
		{
			System.out.print((char) mylist[i]);
		}
	}
	public static int avg(int[] list)
	{
		double sum = 0;
		int i;
		for (i = 0; i < list.length; i++)
		{
			sum += list[i];
		}
		double average = sum/ list.length;
		System.out.println(sum);
		return (int) average;
	}
	public static int max(int[] list)
	{
		double max = list[0];
		int i;
		for( i = 0; i < list.length; i++)
		{
			if (max < list[i])
			{
				max = list[i];
			}
		}
		return (int) max;
	}
	public static int min(int[] list)
	{
		double min = list[0];
		int i;
		for( i = 0; i < list.length; i++)
		{
			if (min > list[i])
			{
				min = list[i];
			}
		}
		return (int) min;
	}
}
