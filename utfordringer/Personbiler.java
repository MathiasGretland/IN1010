package utfordringer;

public class Personbiler extends Kjoretoy implements Biler{
    int antallSitteplasser;
    int aarsAvgift;


    Personbiler(String registreringsnummer, String fabrikkmerke, String eiersNavn, int antallSitteplasser) {
        super(registreringsnummer, fabrikkmerke, eiersNavn);
        this.antallSitteplasser = antallSitteplasser;
        beregnOgSkrivUtAarsAvgift();
    }

    @Override
    public int beregnOgSkrivUtAarsAvgift() {
        aarsAvgift = 3000;
        return aarsAvgift;
    }

    public String toString(){
        String strenge = "Registreringsnummer: " + registreringsnummer;
        strenge += "\nFabrikkmerke: " + fabrikkmerke;
        strenge += "\nEier: " + eiersNavn;
        strenge += "\nAntall sitteplasser: " + antallSitteplasser;
        return strenge;
    }

}
