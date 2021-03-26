package oblig5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class LesInnFiler implements Runnable{
    static int subLengde = 3;
    Beholder beholder = new Beholder();
    BeholderMonitor beholderMonitor = new BeholderMonitor(beholder);
    String filnavn;
    CountDownLatch barriere;

    public LesInnFiler(Beholder beholder, BeholderMonitor beholderMonitor, String filnavn, CountDownLatch barriere){
        this.beholder = beholder;
        this.beholderMonitor = beholderMonitor;
        this.filnavn = filnavn;
        this.barriere = barriere;
    }

    @Override
    public void run() {
        beholderMonitor.laasForLeggTil(lesFil(filnavn));
        try {
            Thread.sleep(1000);
            barriere.countDown();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    static  HashMap<String,Subsekvens> lesFil(String filnavn) {
        File fil = new File(filnavn);
        HashMap<String, Subsekvens> hashMap = new HashMap<>();
        try {
            Scanner leser = new Scanner(new File("oblig5/"+ filnavn));//Gjør om her for å finne riktig filbane
            String linje = "";
            while (leser.hasNextLine()){
                linje = leser.nextLine();
                int lengde = linje.length();
                for (int i = 0; (i+subLengde) <= lengde; i++){
                    String nySubstring = linje.substring(i, (i+subLengde));
                    Subsekvens subsekvens = new Subsekvens(nySubstring);
                    if (!(hashMap.containsKey(nySubstring))){
                        hashMap.put(nySubstring,subsekvens);
                    }
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    return hashMap;
    }

}
