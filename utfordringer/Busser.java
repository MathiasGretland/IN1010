package utfordringer;

public class Busser extends Kjoretoy{
    int antallSitteplasser;


    Busser(String registreringsnummer, String fabrikkmerke, String eiersNavn, int antallSitteplasser) {
        super(registreringsnummer, fabrikkmerke, eiersNavn);
        this.antallSitteplasser = antallSitteplasser;
    }

    public String toString(){
        String strenge = "Registreringsnummer: " + registreringsnummer;
        strenge += "\nFabrikkmerke: " + fabrikkmerke;
        strenge += "\nEier: " + eiersNavn;
        strenge += "\nAntall sitteplasser: " + antallSitteplasser;
        return strenge;
    }
}
