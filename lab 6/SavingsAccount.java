package lab6;

public class SavingsAccount extends BankAccount {
	private double rate = 2.5; 
	private String savingsNumber = "0";
	private String accountNumber;
	
	public SavingsAccount(String name, double balance) {
		super(name, balance);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;	
	}
	public SavingsAccount(SavingsAccount originalAccount, double initialBalance) {
        super(originalAccount, initialBalance);
        this.savingsNumber = originalAccount.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }
	
	public void postInterest() {
		super.deposit(getBalance() * (rate / 12));
	}
@Override
	    public String getAccountNumber() {
	        return accountNumber;
	    }
}

