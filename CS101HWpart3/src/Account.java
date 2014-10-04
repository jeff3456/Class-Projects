/* Author: Jefferson Lee
 * Date: 4/14/2014
 * Section: CS101 section 3 Spring 2014
 */
import java.util.Scanner;
public class Account 
{
	protected int accountNum;
	protected double balance;
	protected String accountType = "Generic";
	static int numAccount = 1;
	
	public Account()
	{
		balance = 0;
		accountNum = generateAccountNumber();
	}
	public Account(double bal)
	{
		this.balance = bal;
		accountNum = generateAccountNumber();
	}
	public Account(double bal, int accountNumber)
	{
		this.accountNum = accountNumber;
		this.balance = bal;
	}
	public boolean deposit(double amount)
	{
		if(amount >= 0)
		{
			balance += amount;
			return true;
		}
		return false;
	}
	public double getBalance()
	{
		return this.balance;
	}
	
	public boolean withdraw (double amount)
	{
		if(amount > 0)
		{
			if(this.balance >= amount)
			{
				this.balance = this.balance - amount;
				return true;
			}
		}
		return false;
	}
	
	public int getAccountNumber()
	{
		return accountNum;
	}
	
	private static int generateAccountNumber()
	{
		return numAccount++;
	}
	
	@Override
	public String toString()
	{
		return "Account #: " + accountNum + "; Type: " + accountType + "; Balance: " + balance;
	}
}
