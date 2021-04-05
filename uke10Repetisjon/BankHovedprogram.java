package uke10Repetisjon;

public class BankHovedprogram {
    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 1000; i++){
            GiOgTa g = new GiOgTa(bank, i);
            Thread traad = new Thread(g);
            traad.start();
        }
    }
}
