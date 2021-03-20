package uke9;

public class GiOgTa implements Runnable{
    Bank bank;
    int belop;

    public GiOgTa(int belop ,Bank b){
        this.belop = belop;
        bank = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            bank.ta(belop);
            bank.gi(belop);
            System.out.println(bank.saldo());
        }
    }
}
