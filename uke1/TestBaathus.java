package uke1;

public class TestBaathus {
    public static void main(String[] args) {
        Baathus baathus = new Baathus(3);

        Baat b1 = new Baat("Honda");
        Baat b2 = new Baat("Cruiser");
        Baat b3 = new Baat("Cabin");
        Baat b4 = new Baat("Sweden");

        baathus.settInn(b1);
        baathus.settInn(b2);
        baathus.settInn(b3);
        baathus.settInn(b4);

        baathus.skrivBaater();
    }
}
