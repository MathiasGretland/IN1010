package uke2;

import java.util.ArrayList;

public class KoSystem {

    ArrayList<KoLapp> koLapper = new ArrayList<>();
    int teller = 0;

    public void trekkKoLapp() {
        teller++;
        KoLapp nyLapp = new KoLapp(teller);
        koLapper.add(nyLapp);

        System.out.println("Du har fått tildelt billettnr ");
        System.out.println(nyLapp.getNummer() + ".");
        System.out.println("Det står "+(koLapper.size()-1) +" foran deg.\n");
    }

    public void betjenKunde() {
        if (koLapper.isEmpty()){
            System.out.println("Ingen er i kø");
        } else {
            KoLapp betjenes = koLapper.remove(0);
            System.out.println("Kunde med billettnr: ");
            System.out.println(betjenes.getNummer() + " er betjent.\n");
        }
    }

    public int antKunder() {
        return koLapper.size();
    }

    public void printKunderIKo() {
        System.out.println("Disse er i kø: ");

        for (KoLapp koLapp: koLapper) {
            System.out.println("nr." + koLapp.getNummer()+ ", ");
        }
        System.out.println("\n\n");
    }
}
