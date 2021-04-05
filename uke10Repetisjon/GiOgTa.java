package uke10Repetisjon;

public class GiOgTa implements Runnable{
    Bank bank;
    int belop;

    public GiOgTa(Bank bank, int belop){
        this.bank = bank;
        this.belop = belop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            bank.gi(belop);
            bank.ta(belop);
            System.out.println(bank.saldo());
        }
    }
}
