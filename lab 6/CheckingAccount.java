package lab6;

public class CheckingAccount extends BankAccount{
	private static final double FEE = 0.15; 
	
	public CheckingAccount(String name, double balance) {
		super(name, balance);
		setAccountNumber(getAccountNumber()+("-10")); 
	}
	
	public boolean withdraw(double amount)
	{
		double newAmount = amount + FEE;
		return super.withdraw(newAmount);
	}
}
