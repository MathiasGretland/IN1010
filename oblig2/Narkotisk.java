package oblig2;

public class Narkotisk extends Legemiddel{
    int styrke;
    public Narkotisk(String navn, int pris, int id, double virkestoff, int styrke) {
        super(navn, pris, id, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){
        return this.styrke;
    }


    public String toString() {
        return "Narkotisk stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
}
