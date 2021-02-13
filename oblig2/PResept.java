package oblig2;

/**
 * Oppretter classen PResept som er en subklasse av HviteResept
 */
public class PResept extends HviteResept{
    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen
     */
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    /**
     *Overrider metoden: prisAaBetale() fra superklassen, og returnerer det som pasienten skal betale
     */
    @Override
    public int prisAaBetale() {
        if (legemiddel.hentPris() <= 108){
            return 0;
        }return legemiddel.hentPris() -108;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return legemiddel + "\n" + utskrivendeLege +"\nPasient ID: " + pasientId + "\nReit: "+ reit + "\nFarge: " + farge() + "\nPris du skal betale: " + prisAaBetale();
    }
}
