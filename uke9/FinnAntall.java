//Må fjernes for at den skal fungere
//Skriv for eksempel: java FinnAntall.java solar minfil.txt 8
package uke9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class FinnAntall {
    public static void main(String[] args) {

        String ordSomSkalFinnes = args[0];
        String filnavn = args[1];
        int antallTraader = Integer.parseInt(args[2]);

        Scanner fil = null;
        try {
            fil = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        int antallLinjer = fil.nextInt();
        fil.nextLine();

        String[] listeOrd = new String[antallLinjer];

        int indeks = 0;
        while (fil.hasNextLine()){
            String ord = fil.nextLine();
            listeOrd[indeks] = ord;
            indeks++;
        }

        CountDownLatch count = new CountDownLatch(antallTraader);
        Ordmonitor monitor = new Ordmonitor();
        int ordPaaHverTraad = antallLinjer / antallTraader;
        indeks = 0;

        for (int i = 0; i < antallTraader; i++){
            int antallOrd;
            if (i == antallTraader - 1){
                antallOrd = antallLinjer - indeks;
            } else {
                antallOrd = ordPaaHverTraad;
            }

            int startIndeks = indeks;
            int sluttIndeks = indeks + antallOrd;
            indeks = indeks += antallOrd;

            Ordfinner o = new Ordfinner(listeOrd, ordSomSkalFinnes, monitor, count, startIndeks, sluttIndeks);
            Thread t = new Thread(o);
            t.start();

        }

        try {
            count.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Ordet forekom " + monitor.hentAntall() + " ganger i filen.");
    }
}
