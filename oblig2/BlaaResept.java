package oblig2;

/**
 * Oppretter classen BlaaResept som er en subklasse av Resept
 */
public class BlaaResept extends Resept{
    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen
     */
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    /**
     *Overrider metoden: farge() fra superklassen, og returnerer Stringer "hvit"
     */
    @Override
    public String farge() {
        return "blaa";
    }

    /**
     *Overrider metoden: prisAaBetale() fra superklassen, og returnerer det som pasienten skal betale
     */
    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris() *25 / 100;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return legemiddel + "\n" + utskrivendeLege +"\nPasient ID: " + pasientId + "\nReit: "+ reit + "\nFarge: " + farge() + "\nPris du skal betale: " + prisAaBetale();
    }
}
