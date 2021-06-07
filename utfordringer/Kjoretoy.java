package utfordringer;

public abstract class Kjoretoy {
    String registreringsnummer;
    String fabrikkmerke;
    String eiersNavn;

    Kjoretoy(String registreringsnummer, String fabrikkmerke, String eiersNavn){
        this.registreringsnummer = registreringsnummer;
        this.fabrikkmerke = fabrikkmerke;
        this.eiersNavn = eiersNavn;
    }
}
