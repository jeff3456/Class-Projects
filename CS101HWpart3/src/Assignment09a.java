/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
public class Assignment09a 
{
	public static void main(String[] args)
	{
		SavingsAccount.setInterestRate(0.012);
		String accountData = "1,Savings,171.0,2,Checking,176.0,3,Checking,229.0,4,Savings,234.0,5,Checking,122.0,6,Savings,204.0,7,Savings,96.0,8,Savings,46.0,9,Savings,283.0,10,Checking,100.0,11,Savings,64.0,12,Checking,211.0,13,Checking,253.0,14,Checking,60.0,15,Checking,215.0,16,Savings,218.0,17,Checking,35.0,18,Checking,145.0,19,Checking,63.0,20,Savings,108.0";  
		String[] splitData = accountData.split(",");
		int numAccounts = splitData.length / 3;
		Account[] a = new Account[numAccounts];
		int counter = 0;
		for (int i = 0; i < numAccounts; i++)
		{
			if(splitData[counter + 1].equals("Savings"))
			{
				a[i] = new SavingsAccount(Double.parseDouble(splitData[counter + 2]),Integer.parseInt(splitData[counter]) );
			}
			else if(splitData[counter + 1].equals("Checking"))
			{
				a[i] = new CheckingAccount(Double.parseDouble(splitData[counter + 2]),Integer.parseInt(splitData[counter]) );
			}
			counter += 3;
		}
		
		for(int i = 0; i < numAccounts; i++)
		{
			System.out.println(a[i]);
		}
		
		for(int i = 0; i < numAccounts; i++)
		{
			if(a[i] instanceof SavingsAccount)
			{
				a[i].deposit(15.);
				((SavingsAccount) a[i]).addInterest(1);
			}
			if(a[i] instanceof CheckingAccount)
			{
				a[i].deposit(10.);
			}
		}
		
		System.out.println("--------\n");
		for(int i = 0; i < numAccounts; i++)
		{
			System.out.println(a[i]);
		}

	}


}
