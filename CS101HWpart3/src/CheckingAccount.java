/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
public class CheckingAccount extends Account
{
	public CheckingAccount()
	{
		super();
		accountType = "Checking";
	}
	public CheckingAccount(double balance)
	{
		super(balance);
		accountType = "Checking";

	}
	public CheckingAccount(double balance, int accountNum)
	{
		super(balance, accountNum);
		accountType = "Checking";

	}
	
	@Override
	public boolean withdraw(double amount)
	{
		if(balance - amount >= -100.)
		{
			balance = balance - amount;
			return true;
		}
		return false;
	}
}
