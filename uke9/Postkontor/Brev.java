package uke9.Postkontor;

public class Brev extends Post{
    public Brev(String beskrivelse, String mottaker) {
        super(beskrivelse, mottaker);
    }

    @Override
    public String toString(){
        String strenge = "Beskrivelse: " + hentBeskrivelse() + "\n";
        strenge += "BREV-Mottaker: " + hentMottaker() + "\n";
        return strenge;
    }
}