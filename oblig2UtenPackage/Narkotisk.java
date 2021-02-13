/**
 * Oppretter classen Narkotisk som er en subklasse av legemiddel
 * Tar også og opretter en til variabel: int styrke
 */
public class Narkotisk extends Legemiddel{
    int styrke;

    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen + int styrke
     */
    public Narkotisk(String navn, int pris, int id, double virkestoff, int styrke) {
        super(navn, pris, id, virkestoff);
        this.styrke = styrke;
    }

    /**
     * Returnerer this.styrke
     */
    public int hentNarkotiskStyrke(){
        return this.styrke;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return "Narkotisk stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
}
