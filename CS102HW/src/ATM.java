/* Jefferson Lee
 * 9/9/2014
 * Data Structures section 1
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class ATM 
{
	public static void main(String[] args)
	{
		if(args.length > 0 && args[0].equals("1"))
		{
			Scanner input;
			
			try 
			{
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
		
		
		// beginning of online mode code
		else
		{
			// create a scanner that takes in commands. One for Strings and one for numbers
			Scanner input = new Scanner(System.in);
			Scanner inputNum = new Scanner(System.in);
						
			// print out list of commands that are possible in 
			// opening bank accounts
			System.out.println("Hello! What transaction would you like to take today? \n"
					+ "Please type: open, quit, login, deposit, withdraw, "
					+ "balance, or terminate \n"
					+ "If you intend to withdraw or deposit, please include the amount after typing the letter with a space in between \n"
					+ "If you intend to login, please include the account number after typing the letter with a space in between \n"
					+ "Then press return to execute the respective command");
			String command = input.nextLine();
			boolean validInput = false;
		
			//change the input to lower-case
			command = command.toLowerCase();
			
			// while loop to make sure the user puts in validInput
			while(!validInput)
			{
				if(command.charAt(0) == 'o')
				{
					validInput = true;
				}
				else
				{
					System.out.println("ERROR \n");
					
					System.out.println("Oops, looks like you need to open an account first \n"
							+ "Please type open and then press return");
					command = input.nextLine();
					command = command.toLowerCase();
				}
			}
			//Create while loop and if statements to control user data which is an ArrayList of Account
			ArrayList<Accounts> accounts = new ArrayList<Accounts>();
			accounts.add(new Accounts());
			System.out.println("Your account number is: " + accounts.get(0).getAccountNo());
			System.out.println();
	
			
			int position = 0; // this is the position in the array
			while(!(command.charAt(0) == 't'))
			{
				System.out.println("What transaction would you like to take next? \n"
						+ "Please type: open, quit, login, deposit, withdraw, "
						+ "balance, or terminate \n"
						+ "Then press return to execute the respective command");
				command = input.nextLine();
				command = command.toLowerCase();
				
				// open
				if (command.charAt(0) == 'o')
				{
					position = accounts.size();
					accounts.add(new Accounts());
					System.out.println("Your account number is: " + accounts.get(position).getAccountNo());
					System.out.println();
					System.out.println("Successful transaction! \n");
				}
				
				// quit
				else if (command.charAt(0) == 'q')
				{
					System.out.println();
					System.out.println("Successful transaction! \n Goodbye! \n");
					
					while(command.charAt(0) != 't' && command.charAt(0) != 'o' && command.charAt(0) != 'l' )
					{
						System.out.println("Please enter terminate, login #### or open");
	
						command = input.nextLine();
						command = command.toLowerCase();
						
						if(command.charAt(0) != 't' && command.charAt(0) != 'o' && command.charAt(0) != 'l')
						{
							System.out.println("ERROR \n");
						}
					}
									
				}
				
				// login 
				else if (command.charAt(0) == 'l')
				{
					System.out.println("Hello");
					
					int accountNum;
					String temp = "";
					int spacePlace = 1;
					
					for(int k = 0; k < command.length(); k++)
					{
						if(command.charAt(k) == ' ')
						{
							spacePlace = k;
							break;
						}
					}
					
					for(int j = spacePlace + 1; j < command.length(); j++)
					{
						temp += command.charAt(j);
					}
					
					accountNum = Integer.parseInt(temp);
					
					boolean findAccount = true;
					
					while(findAccount)
					{
						
						for(int i = 0; i < accounts.size(); i++) // look through ArrayList for correct accountnumber
						{
							if(accounts.get(i).getAccountNo() == accountNum) // if accounts number matches that that is the new account
							{
								position = i;
								findAccount = false;
								System.out.println("Successful transaction! \n");
							}
						}
						
						if(findAccount)
						{
							System.out.println("Sorry! We didn't find an account with that account number.");
							System.out.println("Enter your account number.");
							accountNum = input.nextInt();
						}
					}
				}
				
				// deposit
				else if (command.charAt(0) == 'd') //user enter an amount and deposits in the current account
				{
					
					// look for deposit amount in String
					int amount;
					String temp = "";
					int spacePlace = 1;
					
					for(int k = 0; k < command.length(); k++)
					{
						if(command.charAt(k) == ' ')
						{
							spacePlace = k;
							break;
						}
					}
					
					for(int j = spacePlace + 1; j < command.length(); j++)
					{
						temp += command.charAt(j);
					}
					
					amount = Integer.parseInt(temp);
					
					accounts.get(position).Deposit(amount);
				}
				
				//withdraw
				else if (command.charAt(0) == 'w')
				{
					// look for withdraw amount in String
					int amount;
					String temp = "";
					int spacePlace = 1;
					
					for(int k = 0; k < command.length(); k++)
					{
						if(command.charAt(k) == ' ')
						{
							spacePlace = k;
							break;
						}
					}
					
					for(int j = spacePlace + 1; j < command.length(); j++)
					{
						temp += command.charAt(j);
					}
					
					amount = Integer.parseInt(temp);
					
					accounts.get(position).Withdraw(amount);
				}
				
				// balance
				else if (command.charAt(0) == 'b')
				{
					System.out.println("Your current balance is: " + accounts.get(position).getBalance());
					System.out.println("\nSuccessful transaction! \n");
				}
				
				// if no command is detected
				else if(command.charAt(0) != 't')
				{
					System.out.println("ERROR \n");
				}
			}
		}
	}
}
