package oblig6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Oppretter klassen Labyrint
 */
public class Labyrint {
    int rad;
    int kolonne;
    Rute[][] ruteArray; //Todimensjonal array som tar vare på Rute objekter
    File fil;
    ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<>(); //ArrayList<ArrayList<Tuppel>> som inneholder stiene fram til åpningene samt, også åpningene til slutt

    /**
     * Konstruktør til labyrint
     * @param file Tar inn en av filene som skal kjøres i programmet
     * @throws FileNotFoundException sender FileNotFoundException videre til hovedprogrammet slik at det håndteres der
     * Kjører metoden lesFraFil når konstruktøren opprettes.
     */
    public Labyrint(File file) throws FileNotFoundException {
        fil = file;
        lesFraFil(fil);
    }

    /**
     * Metoden lesFraFil leser inn fra fil, hvor den finner ut:
     * Hvor mange rader og kolonner det todimensjonale Rute-Arrayet skal ha
     * Utifra plassering samt, icon (# eller .) avgjøres det om det skal opprettes et HvitRute, SortRute eller Aapnings objekt
     * @param fil Tar inn en av filene som skal kjøres i programmet
     * @throws FileNotFoundException sender FileNotFoundException videre til hovedprogrammet slik at det håndteres der
     * Helt til slutt kjører den metoden finnNaboer på alle Rute objektene
     */
    private void lesFraFil(File fil) throws FileNotFoundException {
        Scanner input = new Scanner(fil);
        String radOgKolonne = input.nextLine();
        String[] data = radOgKolonne.split(" ");
        rad = Integer.parseInt(data[0]);
        kolonne = Integer.parseInt(data[1]);
        ruteArray = new Rute[rad][kolonne]; //Opprettelsen av ruteArray (Dette kunne også gjort øverst i programmet).
        int radInne = 0;
        int kolonneInne = 0;
        while (input.hasNext()) {
            String ruter = input.nextLine();
            for (int i = 0; i < ruter.length(); i++) {
                char tegn = ruter.charAt(i);
                if (tegn == '#') {
                    SortRute sortRute = new SortRute(radInne, kolonneInne, this);
                    ruteArray[radInne][kolonneInne] = sortRute;
                } else if (tegn == '.') {
                    if (radInne == 0 || radInne == (ruter.length() - 1) || kolonneInne == 0 || kolonneInne == (ruter.length() - 1)) {
                        Aapning aapning = new Aapning(radInne, kolonneInne, this);
                        ruteArray[radInne][kolonneInne] = aapning;
                    } else {
                        HvitRute hvitRute = new HvitRute(radInne, kolonneInne, this);
                        ruteArray[radInne][kolonneInne] = hvitRute;
                    }
                }
                //Går videre til neste kolonne
                kolonneInne++;
            }
            // Nullstiller den før forloopen starter på en ny
            kolonneInne = 0;
            // Nullstiller den slik at vi går til neste rad
            radInne++;
        }
        input.close();
        for (Rute r[] : ruteArray) {
            for (Rute p : r){
                p.finnNaboer();
            }
        }
    }

    /**
     * Metoden finnUtveiFra
     * @param rad Tar inn en rad, brukes som kordinater
     * @param kol Tar inn en kolonne, brukes som kordinater
     * @return Returnerer da en ArrayList<ArrayList<Tuppel>> slik at den samsvarer med hovedprogrammet
     */
    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int rad, int kol){
        Rute r = ruteArray[rad][kol];
        utveier.clear();//Tømmer listen
        r.finnUtvei();
        return utveier;
    }

}
