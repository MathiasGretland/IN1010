package oblig2;

public class PResept extends HviteResept{
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    @Override
    public int prisAaBetale() {
        if (legemiddel.hentPris() <= 108){
            return 0;
        }return legemiddel.hentPris() -108;
    }

    public String toString() {
        return "Legemiddel: " + legemiddel + "\nLege: " + utskrivendeLege +"\nPasient ID: " + pasientId + "\nReit: "+ reit + "\nFarge: " + farge() + "\nPris du skal betale: " + prisAaBetale();
    }
}
