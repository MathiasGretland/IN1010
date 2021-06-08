package traader;

public class Brev extends Post{
    public Brev(String beskrivelse, String mottaker) {
        super(beskrivelse, mottaker);
    }

    public String toString(){
        String strenge = "Beskrivelse: " + beskrivelse + "\nMottaker: " + mottaker + "\n";
        return strenge;
    }
}
