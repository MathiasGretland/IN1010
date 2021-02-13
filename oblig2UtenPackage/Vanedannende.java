/**
 * Oppretter classen Vanedannende som er en subklasse av legemiddel
 * Tar også og opretter en til variabel: int styrke
 */
public class Vanedannende extends Legemiddel{
    int styrke;

    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen + int styrke
     */
    public Vanedannende(String navn, int pris, int id, double virkestoff, int styrke) {
        super(navn, pris, id, virkestoff);
        this.styrke = styrke;
    }

    /**
     * Returnerer this.styrke
     */
    public int hentVanedannendeStyrke(){
        return this.styrke;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString() {
        return "Vanedannende stoff med navn: " +navn+ "\nKoster: " + pris + "\nID: " + id +"\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
}
