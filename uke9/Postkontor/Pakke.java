package uke9.Postkontor;

public class Pakke extends Post{
    public Pakke(String beskrivelse, String mottaker) {
        super(beskrivelse, mottaker);
    }

    @Override
    public String toString(){
        String strenge = "Beskrivelse: " + hentBeskrivelse() + "\n";
        strenge += "PAKKE-Mottaker: " + hentMottaker() + "\n";
        return strenge;
    }
}