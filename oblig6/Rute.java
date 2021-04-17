package oblig6;

import java.util.ArrayList;

public abstract class Rute {
    int rad;
    int kolonne;
    Labyrint labyrint;
    //Referanser til eventuelle nabo-ruter
    Rute nord;
    Rute sor;
    Rute ost;
    Rute vest;

    public Rute(int rad, int kolonne, Labyrint labyrint){
        this.rad = rad;
        this.kolonne = kolonne;
        this.labyrint = labyrint;
    }

    abstract void finnNaboer();
    abstract char tilTegn();
    abstract void gaa(ArrayList<Tuppel> sti, Tuppel forriggeKord);

    public void finnUtvei(){
        Tuppel tuppel2 = new Tuppel(-100, -100); //Tall som aldri kommer til å være en del av en liste, altså dette er ikke forrigeKord fordi dette er det første steget
        ArrayList<Tuppel> u = new ArrayList<>();
        gaa(u, tuppel2);
    }
}
