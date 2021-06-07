package utfordringer;

public class Varebiler extends Kjoretoy implements Biler{
    int maxLasteVekt;
    int aarsAvgift;

    Varebiler(String registreringsnummer, String fabrikkmerke, String eiersNavn, int maxLasteVekt) {
        super(registreringsnummer, fabrikkmerke, eiersNavn);
        this.maxLasteVekt = maxLasteVekt;
        beregnOgSkrivUtAarsAvgift();
    }

    @Override
    public int beregnOgSkrivUtAarsAvgift() {
        aarsAvgift = (maxLasteVekt * 4);
        return aarsAvgift;
    }

    public String toString(){
        String strenge = "Registreringsnummer: " + registreringsnummer;
        strenge += "\nFabrikkmerke: " + fabrikkmerke;
        strenge += "\nEier: " + eiersNavn;
        strenge += "\nMax vekt på last: " + maxLasteVekt;
        return strenge;
    }

}
