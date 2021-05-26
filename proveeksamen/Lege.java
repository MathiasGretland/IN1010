package proveeksamen;

public class Lege extends Ansatte{
    private int legeNummer;

    public Lege(String ansattID, String navn, int legeNummer) {
        super(ansattID, navn);
        this.legeNummer = legeNummer;
    }

}
