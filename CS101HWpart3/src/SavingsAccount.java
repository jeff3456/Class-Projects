/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
public class SavingsAccount extends Account
{
	private static double interestRate = 0.0;
	public SavingsAccount()
	{
		super();
		accountType = "Savings";
	}
	public SavingsAccount(double bal)
	{
		super(bal);
		accountType = "Savings";
	}
	public SavingsAccount(double bal, int accountNum)
	{
		super(bal, accountNum);
		accountType = "Savings";
	}
	
	public static boolean setInterestRate(double rate)
	{
		if((rate >= 0.0) && (rate < 0.10))
		{
			interestRate = rate;
			return true;
		}
		return false;
	}
	
	public void addInterest (int months)
	{
		double interest = interestRate / 12 * months; 
		balance = balance + (balance * interest);
	}
}

