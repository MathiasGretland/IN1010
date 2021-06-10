package traader;

public class DepositRunnable implements Runnable{
    private BankAccount account;
    private double amount;
    private int count;

    public DepositRunnable(BankAccount anAccount, double anAmount, int aCount){
        account = anAccount;
        amount = anAmount;
        count = aCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++){
                account.deposit(amount);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
