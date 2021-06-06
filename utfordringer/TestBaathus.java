package utfordringer;

public class TestBaathus {
    public static void main(String[] args) {
        Baathus baathus = new Baathus(3);
        baathus.settInn(new Baat("SUBARU"));
        baathus.settInn(new Baat("KEKE"));
        baathus.settInn(new Baat("420"));
        baathus.settInn(new Baat("WRONG"));
        baathus.skrivUtBaater();
    }
}
