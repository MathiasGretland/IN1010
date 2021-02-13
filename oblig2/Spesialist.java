package oblig2;

/**
 * Oppretter classen Spesialist som arver av Lege, og implementerer grensesnittet til Godkjennigsfritak
 * Oppretter variabelen String kontrollID
 */
public class Spesialist extends Lege implements Godkjenningsfritak {
    String kontrollID;

    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen + String kontrollID
     */
    public Spesialist(String navn, String kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }

    /**
     *Metode som overrider metoden: hentKontrollID() fra interfacet Godkjenningsfritak
     * Returnerer this.kontrollID
     */
    @Override
    public String hentKontrollID() {
        return this.kontrollID;
    }

    /**
     *Returnerer en utskrift som er tilpasset klassen på en ryddig og fin måte.
     */
    public String toString(){
        return "Spesialist: " + hentLege() + "\nKontroll ID: " + hentKontrollID();
    }
}
