package oblig2;

/**
 * Oppretter classen Lege
 * Oppretter variabelen String navn
 */
public class Lege {
    String navn;

    /**
     *Oppretter konstruktøren, med parameteren String navn
     */
    public Lege(String navn){
        this.navn = navn;
    }

    /**
     * Returnerer this.navn
     */
    public String hentLege(){
        return this.navn;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString(){
        return "Lege: " + hentLege();
    }
}
