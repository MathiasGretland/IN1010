package backInTown;

public class Buss extends Kjoretoy{
    int antallSittePlasser;

    public Buss(String registreringsnummer, String fabrikkMerke, String eierNavn, int antallSitteplasser) {
        super(registreringsnummer, fabrikkMerke, eierNavn);
        this.antallSittePlasser = antallSitteplasser;
    }
}
