package utfordringer;

import java.util.ArrayList;

public class KoSystem{
    ArrayList<KoLapp> koLappArrayList = new ArrayList<>();

    //Lager et nytt objekt av KoLapp, printer ut informasjon om den og legger den til i listen over koLapper.
    public void trekkKoLapp(){
        KoLapp koLapp = new KoLapp();
        System.out.println("Du har fått tildelt billettnr " + koLapp.hentNummer() + ".");
        koLappArrayList.add(koLapp);
    }

    //Henter ut, printer ut informasjon og fjerner den forste kolappen i lista. Gir feilmelding dersom ingen kunder staar i ko.
    public void betjenKunde(){
        if (koLappArrayList.size() != 0){
            KoLapp info = koLappArrayList.get(0);
            System.out.println("Kunde med billettnr. " + info.hentNummer() + " er betjent.");
            koLappArrayList.remove(0);
        }else {
            System.out.println("Det er ingen kunder");
        }
    }

    //Returnerer antall kunder som er i ko.
    public int antKunder(){
        return koLappArrayList.size();
    }

    //Printer alle kunder i ko
    public void printKunderIKo(){
        System.out.println("Det står " + antKunder() + " personer i kø.");
    }

}