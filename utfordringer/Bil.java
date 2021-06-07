package utfordringer;

public class Bil {
    String registreringsnummer;
    int antallPass;

    Bil(String registreringsnummer, int antallPass){
        this.registreringsnummer = registreringsnummer;
        this.antallPass = antallPass;
    }

    public String toString(){
        String strenge = "Registreringsnummer: " + registreringsnummer ;
        strenge += "\nAntall plasser: " + antallPass;
        return strenge;
    }
}
