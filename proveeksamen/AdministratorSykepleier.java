package proveeksamen;

public class AdministratorSykepleier extends Sykepleier implements Administrator{
    public AdministratorSykepleier(String ansattID, String navn) {
        super(ansattID, navn);
    }

    @Override
    public String finnAnsvar() {
        return null;
    }
}
