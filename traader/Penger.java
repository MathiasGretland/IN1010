package traader;

public class Penger implements Runnable{
    Bank bank;
    int belop;

    public Penger(Bank bank, int belop){
        this.bank = bank;
        this.belop = belop;
    }

    @Override
    public void run() {
        bank.ta(belop);
        bank.gi(belop);
        System.out.println(bank.saldo());
    }
}
