public class Client {

	public static void main(String[] args) {
		ICICIBank bank=new ICICIBank();
		
		
			try {
				System.out.println(bank.createAccount(101,30000));
				System.out.println(bank.createAccount(102, 30000));
			} 
			catch (InsufficientBalanceException e) {
				
				System.out.println("Minimum balance required");
			}

		try
		{
			System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
			
		}catch(InvalidAccountNumberException ian)
		{
			System.out.println("Invalid account number");
		}catch(InsufficientBalanceException ibe)
		{
			System.out.println("insufficient balance");
		}
		
		try {
			System.out.println("New Balance after depositing = "+bank.depositAmount(102, 4000));
		} catch (InvalidAccountNumberException e) {
			System.out.println("Invalid account number");
		}
		
		
		try {
			System.out.println(bank.fundTransfer(101,102,200));
		} catch (InvalidAccountNumberException e) {
			System.out.println("Invalid account number");
		} catch (InsufficientBalanceException e) {
			System.out.println("insufficient balance");
		}

	
	}

}

