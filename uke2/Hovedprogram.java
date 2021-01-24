package uke2;

public class Hovedprogram {
    public static void main(String[] args) {
        Brev brevet = new Brev("Per Askeladd", "Espen Askeladd");
        brevet.skrivLinje("Hvorddan har du det?");
        brevet.skrivLinje("Jeg har det bra!");
        brevet.lesBrev();
    }
}
