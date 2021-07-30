package backInTown;

public class Personbiler extends Kjoretoy{
    int antallSittePlasser;
    int aarsAvgift;

    public Personbiler(String registreringsnummer, String fabrikkMerke, String eierNavn,int antallSittePlasser) {
        super(registreringsnummer, fabrikkMerke, eierNavn);
        this.antallSittePlasser = antallSittePlasser;
        aarsAvgift();
    }

    public void aarsAvgift(){
        aarsAvgift = 3000;
    }
}
