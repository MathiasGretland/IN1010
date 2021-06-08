package traader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private Lock laas;
    private Condition harForLite;
    private Condition harForMye;

    public BankAccount(){
        balance = 0;
        laas = new ReentrantLock();
        harForLite = laas.newCondition();
        harForMye = laas.newCondition();
    }

    public void deposit(double antall){
        laas.lock();
        try {
            while (balance >= antall){
                harForMye.await();
            }
            System.out.print("Setter in: " + antall);
            double nyAntall = balance + antall;
            System.out.println(", ny saldo er " + nyAntall );
            balance = nyAntall;
            harForLite.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }
    }

    public void withdraw(double antall){
        laas.lock();
        try {
            while (balance < antall){
                harForLite.await();
            }
            System.out.print("Fjerner : " + antall);
            double nyAntall = balance - antall;
            System.out.println(", ny saldo er " + nyAntall );
            balance = nyAntall;
            harForMye.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }

    }

    public double getBalance(){
        return balance;
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        final double amount = 100;
        final int repetisjoner = 100;
        final int traader = 100;
        for (int i = 0; i <= traader; i++){
            DepositRunnable d = new DepositRunnable(account,amount,repetisjoner);
            WithdrawRunnable w = new WithdrawRunnable(account,amount,repetisjoner);
            Thread dt = new Thread(d);
            Thread wt = new Thread(w);
            dt.start();
            wt.start();
        }
    }
}
