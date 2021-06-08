package traader;

public class Pakke extends Post{
    public Pakke(String beskrivelse, String mottaker) {
        super(beskrivelse, mottaker);
    }

    public String toString(){
        String strenge = "Beskrivelse: " + beskrivelse + "\nMottaker: " + mottaker + "\n";
        return strenge;
    }
}
