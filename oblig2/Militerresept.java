package oblig2;

public class Militerresept extends HviteResept{
    public Militerresept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }

    public String toString() {
        return "Legemiddel: " + legemiddel + "\nLege: " + utskrivendeLege +"\nPasient ID: " + pasientId + "\nReit: "+ reit + "\nFarge: " + farge() + "\nPris du skal betale: " + prisAaBetale();
    }
}
