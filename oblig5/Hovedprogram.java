package oblig5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Hovedprogram {
    static String metadataFilbane = "oblig5/metadata.csv";//Gjør om her for å finne riktig filbane
    public static void main (String [ ] args) throws IOException {
        Beholder friskePersonerBeholder = new Beholder();
        BeholderMonitor friskeMonitor = new BeholderMonitor(friskePersonerBeholder);
        Beholder sykePersonerBeholder = new Beholder();
        BeholderMonitor sykeMonitor = new BeholderMonitor(sykePersonerBeholder);
        ArrayList<String> listeMedFiler = new ArrayList<>();
        int antallTraader = 0;
        String linje;
        Thread traader = null;
        CountDownLatch barriere = new CountDownLatch(2);
        try{
            Scanner leser = new Scanner(new File(metadataFilbane));
            System.out.println("Velkommen til Beholder hovedprogram ");
            leser.nextLine(); //Hopper over første linje
            while(leser.hasNextLine()) {
                linje = leser.nextLine();
                linje = linje.trim();
                listeMedFiler.add(linje);
                antallTraader++;
            }
            System.out.println("Antall traader som skal leses inn er: " + antallTraader);
            leser.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Finner ikke filinnlesning!");
        }
        for (String filer : listeMedFiler){
            String [] data = filer.split(",");
            String fil = data[0];
            if (data[1].equals("True")){
                LesInnFiler runnableForSyke = new LesInnFiler(sykePersonerBeholder, sykeMonitor, fil, barriere);
                traader = new Thread(runnableForSyke);
                System.out.println(fil + " er en Sykfil");
                traader.start();
            }
            if (data[1].equals("False")){
                LesInnFiler runnableForFriske = new LesInnFiler(friskePersonerBeholder, friskeMonitor, fil, barriere);
                traader = new Thread(runnableForFriske);
                System.out.println(fil + " er en Friskfil");
                traader.start();
            }
        }

        try{
            barriere.await();
        } catch (InterruptedException e) {
            System.out.println("Traaden ville ikke vente!");
        }

        System.out.println();
        System.out.println("Tester hele beholderen med syke personer før fletting");
        sykePersonerBeholder.testHele();
        System.out.println();

        System.out.println("Tester hele beholderen med friske personer før fletting");
        friskePersonerBeholder.testHele();
        System.out.println();

        System.out.println("Tester hele beholderen med syke personer etter fletting");
        while (sykePersonerBeholder.antall() > 1) {
            FletteTraad runnableForFlettingSyke = new FletteTraad(sykePersonerBeholder,sykeMonitor, barriere);
            traader = new Thread(runnableForFlettingSyke);
            traader.start();
        }

        try{
            barriere.await();
        } catch (InterruptedException e) {
            System.out.println("Traaden ville ikke vente!");
        }

        sykePersonerBeholder.testHele();
        System.out.println();

        System.out.println("Tester hele beholderen med friske personer etter fletting");
        while (friskePersonerBeholder.antall() > 1) {
            HashMap<String, Subsekvens> res = Beholder.flette(friskePersonerBeholder.taEn(), friskePersonerBeholder.taEn());
            friskePersonerBeholder.leggTil(res);
        }
        friskePersonerBeholder.testHele();



    }


}


