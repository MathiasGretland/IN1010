package uke2;

public class TestGruppeoppmoete {
    public static void main(String[] args) throws Exception{
        Gruppeoppmoete registrer = new Gruppeoppmoete();
        registrer.lesInnFil("uke2/Gruppeliste.txt");
        registrer.registrerOppmoete("Lisa");
        registrer.registrerOppmoete("Bilal");
        registrer.registrerOppmoete("Jens");
        registrer.registrerOppmoete("Emilie");
        registrer.skrivUtAlleOppmoette();
    }
}
