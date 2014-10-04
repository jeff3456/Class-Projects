import java.io.*;
import java.util.*;
/* make file?
// Do I need to do the normal homework?
// will graders look through code?
// command line (0/1) ?
 
// try and catch for array size?
 * if the input is Deposit vs D, you need to create cases for both
 * 
 * 
 * */
public class ATMOffline 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner input;
		
		
		try {
			File sourceFile = new File("InputFile.txt");
			File targetFile = new File("OutputFile.txt");

			input = new Scanner(sourceFile);
			PrintWriter output = new PrintWriter(targetFile);
			
			ArrayList<Accounts> accounts = new ArrayList<Accounts>();
			int position = 0;
			
			while(input.hasNext())
			{

				
				// take input lines and organize the commands into an array
				String line = input.nextLine();
				
				String[] splitLine = line.split(" ");
				
				// make the string lowercase
				String command = splitLine[0];
				command = command.toLowerCase();
				
				double amount = 0;
								
				if(splitLine.length > 1 )
				{
					amount = Double.parseDouble(splitLine[1]);
				}
				
				// quit comes first because it has precedence over other functions
				if (command.charAt(0) == 'q')
				{
					output.println("Goodbye");
					
					while(command.charAt(0) != 't' && command.charAt(0) != 'o' && command.charAt(0) != 'l' )
					{
						line = input.nextLine();

						splitLine = line.split(" ");
						
						command = splitLine[0];
						command = command.toLowerCase();
						
						if(splitLine.length > 1 )
						{
							amount = Double.parseDouble(splitLine[1]);
						}
						
						if(command.charAt(0) != 't' && command.charAt(0) != 'o' && command.charAt(0) != 'l' )
						{
							output.println("ERROR");
						}
					}
				}
				
				// open
				if (command.charAt(0) == 'o')
				{
					position = accounts.size();
					accounts.add(new Accounts());
					
					// output account number
					output.println(accounts.get(position).getAccountNo());
					
				}
				
				// login 
				if (command.charAt(0) == 'l')
				{
					output.println("Hello");
					
					for(int i = 0; i < accounts.size(); i++)
					{
						if(accounts.get(i).getAccountNo() == amount)
						{
							position = i;
						}
					}
				}
				
				// deposit
				else if (command.charAt(0) == 'd') //user enter an amount and deposits in the current account
				{
					// look for deposit amount in String
					
					accounts.get(position).Deposit(amount);
					
					output.println(amount);
				}
				
				//withdraw
				else if (command.charAt(0) == 'w')
				{
					// output amount withdrawn
					
					output.println(amount);
					
					accounts.get(position).Withdraw(amount);
				}
				
				// balance
				else if (command.charAt(0) == 'b')
				{
					output.println(accounts.get(position).getBalance());
				}
				
				// if no command is detected
				if(command.charAt(0) == 't')
				{
					output.println("Terminated");
				}
				
				
			}
			output.close();
			input.close();
			
		} 
		catch (FileNotFoundException e) {
			// catch block
			e.printStackTrace();
		}
		
	}
}
