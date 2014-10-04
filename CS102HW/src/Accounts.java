/* Jefferson Lee
 * 9/9/2014
 * Data Structures section 1
*/

public class Accounts 
{
	private int accountNum;
	private double balance = 0;
	public static int NextAcctNo = 1000;
	
	public Accounts()
	{
		balance = 0.0;
		accountNum = NextAcctNo++;
		
	}
	public void Deposit(double amount)
	{
		// make sure deposit is over or equal to 0
		if(amount >= 0)
		{
			this.balance += amount;
			System.out.println("Successful transaction! \n");
		}
		else
		{
			System.out.println("ERROR \n");

			System.out.println("You've entered an invalid deposit \n");
		}
	}
	
	public void Withdraw(double amount)
	{
		// make sure that withdrawal isn't going into negatives. Also withdraw amount cannot be negative
		if((balance - amount < 0) || amount < 0)
		{
			System.out.println("ERROR \n");

			System.out.println("You've withdrawn an invalid amount \n");
		}
		else
		{
			balance -= amount;
			System.out.println("Successful transaction! \n");
		}
	}
	public double getBalance()
	{
		return balance;
	}
	public int getAccountNo()
	{
		return accountNum;
	}
}

