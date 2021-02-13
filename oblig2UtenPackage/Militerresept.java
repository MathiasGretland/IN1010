/**
 * Oppretter classen Militerresept som er en subklasse av HviteResept
 */
public class Militerresept extends HviteResept{

    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen
     */
    public Militerresept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    /**
     *Overrider metoden: prisAaBetale() fra superklassen, og returnerer det som pasienten skal betale
     */
    @Override
    public int prisAaBetale() {
        return 0;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return legemiddel + "\n" + utskrivendeLege +"\nPasient ID: " + pasientId + "\nReit: "+ reit + "\nFarge: " + farge() + "\nPris du skal betale: " + prisAaBetale();
    }
}
