package uke5;

public class DyreTest {
    public static void main(String[] args) {
        Rovdyr[] rovdyrListe= new Rovdyr[2];
        rovdyrListe[0] = new Bjorn();
        rovdyrListe[1] = new Ulv();

        Planteetere[] planteeterListe = new Planteetere[2];
        planteeterListe[0] = new Elg();
        planteeterListe[1] = new Sau();

        rovdyrListe[0].kanJakte();
        rovdyrListe[1].kanJakte();
        planteeterListe[0].beskytteSegSelv();
        planteeterListe[1].beskytteSegSelv();
    }
}
