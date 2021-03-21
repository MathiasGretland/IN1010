package uke9.Postkontor;

public class Post {
    String beskrivelse;
    String mottaker;

    public Post(String beskrivelse, String mottaker){
        this.beskrivelse = beskrivelse;
        this.mottaker = mottaker;
    }

    public String hentBeskrivelse(){
        return this.beskrivelse;
    }

    public String hentMottaker(){
        return this.mottaker;
    }

    @Override
    public String toString(){
        String strenge = "Beskrivelse: " + hentBeskrivelse() + "\n";
        strenge += "Mottaker: " + hentMottaker() + "\n";
        return strenge;
    }

}
