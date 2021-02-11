package oblig2;

public class Vanlig extends Legemiddel{
    public Vanlig(String navn, int pris, int id, double virkestoff) {
        super(navn, pris, id, virkestoff);
    }

    public String toString() {
        return "Narkotisk stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff;
    }
}
