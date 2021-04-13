package oblig6;

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
    abstract void gaa();
}
