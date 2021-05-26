package proveeksamen;

public class Overlege extends Lege{
    private String spesType;

    public Overlege(String ansattID, String navn, int legeNummer,String spesType) {
        super(ansattID, navn, legeNummer);
        this.spesType = spesType;
    }


}
