package oblig2;

public class Vanedannende extends Legemiddel{
    int styrke;

    public Vanedannende(String navn, int pris, int id, double virkestoff, int styrke) {
        super(navn, pris, id, virkestoff);
        this.styrke = styrke;
    }

    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    public String toString() {
        return "Vanedannende stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
}
