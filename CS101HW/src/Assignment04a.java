
/* Author: Jefferson Q. Lee
 * Date: 02/24/2014
 * Section: CS101, Section 03, Spring 2014
 */
import java.util.Scanner;
public class Assignment04a 
{

	public static void main(String[] args) 
	{
		Scanner inputNum = new Scanner(System.in);
		System.out.print("How many paients do you wish to analyze? ");
		int numPatients = inputNum.nextInt();
		int i;
		double[] listOfBmi = new double[numPatients];
		double bmi;
		for(i = 0 ; i < numPatients; i++)
		{
			System.out.print("Patient #" + (i+1) +": Enter Height in inches: ");
			int height = inputNum.nextInt();
			System.out.print("Patient #" + (i+1) +": Enter Weight in inches: ");
			int weight = inputNum.nextInt();
			bmi = bmi(height,weight);

			System.out.print("Patient #" + (i+1));
			System.out.printf(" has a BMI of %,.2f " , bmi);
			System.out.println("");
			if(bmi < 18.5)
			{
				System.out.println("Patient #" + (i+1) + " is considered Underweight");
			}
			else if (bmi < 24.9 && bmi >= 18.5 )
			{
				System.out.println("Patient #" + (i+1) + " is considered Normal weight");
			}
			else if( bmi < 29.9 && bmi >= 24.9)
			{
				System.out.println("Patient #" + (i+1) + " is considered Overweight");
			}
			else if( bmi >= 29.9)
			{
				System.out.println("Patient #" + (i+1) + " is considered Obese");
			}
			listOfBmi[i] = bmi;
		}
		System.out.printf("Highest BMI: %,.2f ", max(listOfBmi));
		bmiResult(max(listOfBmi));
		System.out.printf("Lowest BMI: %,.2f " , min(listOfBmi));
		bmiResult(min(listOfBmi));
		System.out.printf("Average BMI: %,.2f ", avg(listOfBmi));
		bmiResult(avg(listOfBmi));
	}
	public static double max(double[] list)
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
		return max;
	}
	public static double min(double[] list)
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
		return min;
	}
	public static double avg(double[] list)
	{
		double sum = 0;
		int i;
		for (i = 0; i < list.length; i++)
		{
			sum += list[i];
		}
		double average = sum/ list.length;
		return average;
	}
	public static double bmi(int inches, int weight)
	{
		double BMI = (double) (weight * 703) / (inches * inches);
		return BMI;
	}
	public static void bmiResult(double bmi)
	{
		if(bmi < 18.5)
		{
			System.out.println("Underweight");
		}
		else if (bmi < 24.9 && bmi >= 18.5 )
		{
			System.out.println("Normal weight");
		}
		else if( bmi < 29.9 && bmi >= 24.9)
		{
			System.out.println("Overweight");
		}
		else if( bmi >= 29.9)
		{
			System.out.println("Obese");
		}
	}
}
