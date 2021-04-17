package oblig6;

public class Tuppel {
    int rad;
    int kolonne;

    public Tuppel(int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
    }

    public String toString(){
        String strenge = "(" + rad + "," + kolonne + ")";
        return strenge;
    }
}
