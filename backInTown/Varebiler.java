package backInTown;

public class Varebiler extends Kjoretoy{
    int maxVekt;
    int aarsAvgift;

    public Varebiler(String registreringsnummer, String fabrikkMerke, String eierNavn, int maxVekt) {
        super(registreringsnummer, fabrikkMerke, eierNavn);
        this.maxVekt = maxVekt;
    }

    public int aarsAvgift(){
        return aarsAvgift = maxVekt * 4;
    }

    public String toString(){
        String strenge = "RegistreringsNummer: " + registreringsnummer + "\nFabrikkmerke: " + fabrikkMerke + "\nEier: " + eierNavn + "\nMaxVekt: " + maxVekt;
        strenge += "\nÅrsavgift: " + aarsAvgift();
        return strenge;
    }
}
