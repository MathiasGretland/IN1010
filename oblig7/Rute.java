package oblig7;

import java.util.ArrayList;

/**
 * Oppretter den abstrakte klassen Rute
 */
public abstract class Rute {
    int rad;
    int kolonne;
    Labyrint labyrint;
    //Referanser til eventuelle nabo-ruter
    Rute nord;
    Rute sor;
    Rute ost;
    Rute vest;

    /**
     * Konstruktøren til alle Rute objekt
     * @param rad Tar inn rad, brukes til kordinater
     * @param kolonne Tar inn kolonne, brukes til kordinater
     * @param labyrint Tar inn et Labyrint objekt
     */
    public Rute(int rad, int kolonne, Labyrint labyrint){
        this.rad = rad;
        this.kolonne = kolonne;
        this.labyrint = labyrint;
    }


    abstract void finnNaboer(); //Oppretter en abstract metode kalt finnNaboer, som finner naboene til Rute objektene
    abstract char tilTegn(); //Oppretter en abstract metode kalt tilTegn som gjør returner en char
    abstract void gaa(ArrayList<Tuppel> sti, Tuppel forriggeKord); //Oppretter en abstrakt metode gaa som utføres forskjellige fra alle klassene som implementerer Rute klassen.

    /**
     * Metoden finnUtvei Finner alle utveier fra ruten ved hjelp av kall på gaa
     */
    public void finnUtvei(){
        Tuppel tuppel2 = new Tuppel(-100, -100); //Tall som aldri kommer til å være en del av en liste, altså dette er ikke forrigeKord fordi dette er det første steget
        ArrayList<Tuppel> u = new ArrayList<>();
        gaa(u, tuppel2);
    }
}
