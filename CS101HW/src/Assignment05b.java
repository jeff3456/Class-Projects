/* Author: Jefferson Lee
 * Date: 03/05/2014
 * Section CS101, Section 03 Spring 2014
 */
import java.util.Scanner;
public class Assignment05b {

	public static void main(String[] args) 
	{
		Scanner inputNum = new Scanner(System.in);
		Scanner inputName = new Scanner(System.in);
		
		System.out.print("How many students? ");
		int numOfStud = inputNum.nextInt();
		
		String [] names = new String [numOfStud];
		int [] scores = new int [numOfStud];
		
		for(int i = 0; i < numOfStud; i++)
		{
			System.out.print("Student #" + (i+1) +" name: ");
			names[i] = inputName.nextLine();
			System.out.print("Student #" + (i+1) + " score: ");
			scores[i] = inputNum.nextInt();
		}
		int temp;
		String tempS;

		for(int i = 0; i < numOfStud; i++)
		{
			for(int k = i + 1; k < numOfStud; k++)
			{
				if(scores[i] > scores[k])
				{
					temp= scores[i];
					scores[i] = scores[k];
					scores[k] = temp;
					
					tempS = names[i];
					names[i] = names[k];
					names[k] = tempS;
				}
			}
		}
		System.out.println("Course roster sorted by score: ");
		for(int i = 0 ; i< numOfStud; i++)
		{
			System.out.println(scores[i] + " - " + names[i]);
		}
	}

}
