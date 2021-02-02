package uke4;

public class KlasseTestprogram {
    public static void main(String[] args) {
        KlasseB Bswag = new KlasseB();
        KlasseA Aswag = Bswag;

        Bswag.skrivKlasse();
        Aswag.skrivKlasse();
    }
}
