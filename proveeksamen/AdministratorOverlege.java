package proveeksamen;

public class AdministratorOverlege extends Overlege implements Administrator{
    String ansvarskode;

    public AdministratorOverlege(String ansattID, String navn, int legeNummer, String spesType, String ansvarskode) {
        super(ansattID, navn, legeNummer, spesType);
        this.ansvarskode = ansvarskode;
    }

    @Override
    public String finnAnsvar() {
        return ansvarskode;
    }
}
