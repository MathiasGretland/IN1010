package oblig2;

/**
 * Oppretter classen Vanlig som er en subklasse av legemiddel
 */
public class Vanlig extends Legemiddel{
    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen + int styrke
     */
    public Vanlig(String navn, int pris, int id, double virkestoff) {
        super(navn, pris, id, virkestoff);
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return "Vanlig stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff;
    }
}
