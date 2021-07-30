package backInTown;

public abstract class Kjoretoy {
    String registreringsnummer;
    String fabrikkMerke;
    String eierNavn;

    public Kjoretoy(String registreringsnummer, String fabrikkMerke, String eierNavn){
        this.registreringsnummer = registreringsnummer;
        this.fabrikkMerke = fabrikkMerke;
        this.eierNavn = eierNavn;
    }

    public static void main(String[] args) {
        Buss bussen = new Buss("AY29182", "Mercedes", "Magnus", 24);
        Personbiler bilan = new Personbiler("KJ241421", "Toyota", "Mjongo", 5);
        Varebiler varer = new Varebiler("DP231243", "Carsten", "Vegar", 1232);
        System.out.println(varer);

    }
}
