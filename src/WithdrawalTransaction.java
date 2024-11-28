import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {

        if (ba.getBalance() >= getAmount()) {
            ba.withdraw(getAmount()); 
            System.out.println("Withdrawn: " + getAmount());
        } else {
      
            try {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            } catch (InsufficientFundsException e) {
              
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean reverse(BankAccount ba) {
      
        if (ba.getBalance() >= getAmount()) {
            ba.deposit(getAmount()); 
            System.out.println("Withdrawal reversed: " + getAmount());
            return true;
        }
        return false;  
    }
}
