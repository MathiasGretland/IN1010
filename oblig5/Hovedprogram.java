package oblig5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Kjører programmet
 */
public class Hovedprogram {
    static String metadataFilbane = "oblig5/metadata.csv";//Gjør om her for å finne riktig filbane
    public static void main (String[] args) throws InterruptedException {
        int antallTraaderFletting = 6;// Gjør om til den variabelen under for å få riktig.
        //int antallTraaderFletting = Integer.parseInt(args[0]);
        int sykeTraaderFletting = (antallTraaderFletting/2);
        int friskeTraaderFletting = (antallTraaderFletting/2);
        Beholder friskePersonerBeholder = new Beholder();
        BeholderMonitor friskeMonitor = new BeholderMonitor(friskePersonerBeholder);
        Beholder sykePersonerBeholder = new Beholder();
        BeholderMonitor sykeMonitor = new BeholderMonitor(sykePersonerBeholder);
        ArrayList<String> listeMedFiler = new ArrayList<>();
        int antallTraader = 0;
        String linje;
        Thread traader = null;
        CountDownLatch barriere = new CountDownLatch(2);
        CountDownLatch barriereForFlettingSyke = new CountDownLatch(sykeTraaderFletting);
        CountDownLatch barriereForFlettingFriske = new CountDownLatch(friskeTraaderFletting);
        /**
         * Leser inn filene og plasserer de i riktige beholdere
         */
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

        /**
         * Gir info om syke beholderen og friske beholderen før fletting er startet
         */
        System.out.println();
        System.out.println("Tester hele beholderen med syke personer før fletting");
        sykePersonerBeholder.testHele();
        System.out.println();

        System.out.println("Tester hele beholderen med friske personer før fletting");
        friskePersonerBeholder.testHele();
        System.out.println();

        /**
         * Her starter flettingen for den syke beholderen
         */
        System.out.println("Tester hele beholderen med syke personer etter fletting");
        while (sykePersonerBeholder.antall() > 1) {
            FletteTraad runnableForFlettingSyke = new FletteTraad(sykePersonerBeholder,sykeMonitor, barriereForFlettingSyke);
            traader = new Thread(runnableForFlettingSyke);
            traader.start();
            traader.join();
        }

        try{
            barriereForFlettingSyke.await();
        } catch (InterruptedException e) {
            System.out.println("Traaden ville ikke vente!");
        }
        System.out.println();
        sykePersonerBeholder.testHele();

        System.out.println();

        /**
         * Her starter flettingen for den frikse beholderen
         */
        System.out.println("Tester hele beholderen med friske personer etter fletting");
        while (friskePersonerBeholder.antall() > 1) {
            FletteTraad runnableForFlettingFriske = new FletteTraad(friskePersonerBeholder,friskeMonitor, barriereForFlettingFriske);
            traader = new Thread(runnableForFlettingFriske);
            traader.start();
            traader.join();
        }
        try{
            barriereForFlettingFriske.await();
        } catch (InterruptedException e) {
            System.out.println("Traaden ville ikke vente!");
        }
        friskePersonerBeholder.testHele();

        //Her kjøres den enkle statiske testen
        skrivUtResultat(sykePersonerBeholder, friskePersonerBeholder);

        }

    /**
     * Metode som skriver ut den statiske testen på en fin måte.
     * @param sykeBeholder Tar inn den sykebeholderen
     * @param friskeBeholder Tar inn den friskebeholderen
     */
    static void skrivUtResultat(Beholder sykeBeholder, Beholder friskeBeholder){
        HashMap<String,Subsekvens> syke = sykeBeholder.taEn();
        HashMap<String,Subsekvens> friske = friskeBeholder.taEn();
        int antall = 0;
        for (String dominante : syke.keySet()){
            if (friske.containsKey(dominante)){
                int forskjell = (syke.get(dominante).hentAntall() - friske.get(dominante).hentAntall());
                if (forskjell >= 5){
                    antall++;
                    System.out.println("Viruset " + dominante + " sin forskjell mellom syke og friske var " + forskjell);
                    System.out.println("Totalt syke pasienter som har viruset er: " + syke.get(dominante).hentAntall());
                    System.out.println("Totalt friske pasienter som hadde viruset er: " + friske.get(dominante).hentAntall());
                    System.out.println();
                }
            }
        }
        System.out.println("Antall som ble skrevet ut: " + antall); //Utifra de reelle filene fant jeg ut at det er 17 virus.
    }
}



