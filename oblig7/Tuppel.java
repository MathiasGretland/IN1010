package oblig7;

/**
 * Oppretter klassen Tuppel
 */
public class Tuppel {
    int rad;
    int kolonne;

    /**
     * Konstruktøren til Tuppel klassen
     * @param rad Tar inn en rad, brukes til kordinater
     * @param kolonne Tar in en kolone, brukes til kordinater
     */
    public Tuppel(int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
    }

    /**
     * toString metoden til Tuppel gjøres om på slik at det skrives ut pent
     * @return returner strengen.
     */
    public String toString(){
        String strenge = "(" + rad + "," + kolonne + ")";
        return strenge;
    }
}
