package traader;

public class WithdrawRunnable implements Runnable{
    private BankAccount account;
    private double amount;
    private int count;

    public WithdrawRunnable(BankAccount anAccount, double anAmount, int aCount){
        account = anAccount;
        amount = anAmount;
        count = aCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++){
                account.withdraw(amount);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
