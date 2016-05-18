
import java.util.LinkedList;

public class ICICIBank {
	 //int minBal=500;
	LinkedList<Account> accounts=new LinkedList<Account>();
	
	
	public String createAccount(int accountNumber,int amount)throws InsufficientBalanceException
	{
		
		Account account=new Account(accountNumber,amount);
		if(amount>=500)
		{
		accounts.add(account); //coz we are creating LinkedList Object
		
		return "account created successfully";
		}
	
			throw new InsufficientBalanceException();
		}
	
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account:accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
			
		}
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException,InsufficientBalanceException
	{
		Account account = searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
	
	
	public int depositAmount(int accountNumber, int amount)throws InvalidAccountNumberException
	{
		Account account = searchAccount(accountNumber);
		
			
			account.setAmount(account.getAmount()+amount);
			return account.getAmount();
			
		


		
	}
	
	
	
	public String fundTransfer(int accountNumber1,int accountNumber2,int amount)throws InvalidAccountNumberException,InsufficientBalanceException
	{
		
		Account account1 = searchAccount(accountNumber1);
		Account account2 = searchAccount(accountNumber2);
		
		if((account1.getAmount()-amount<0))
		{
			throw new InsufficientBalanceException();
		}
		else
		{
			account1.setAmount(account1.getAmount()-amount);
			account2.setAmount(account2.getAmount()+amount);
			return "Fund Transferred!! from "+account1.getAccountNumber()+" to "+account2.getAccountNumber();
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

