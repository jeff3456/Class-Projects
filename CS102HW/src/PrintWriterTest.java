import java.io.*;
public class PrintWriterTest 
{
	public static void main(String[] args)throws java.io.IOException
	{
		java.io.File myFile = new java.io.File("Input.txt");
		
		if (myFile.exists())
		{
			System.out.println("InputFile.txt exists");
			System.exit(0);
		}
		
		java.io.PrintWriter outFile = new java.io.PrintWriter(myFile);
		outFile.println("Courant Institute, NYU");
		outFile.print(251);
		outFile.println(", Mercer Street");
		
		System.out.println("Written to InputFile.txt");

		outFile.close();
		
	}
}
