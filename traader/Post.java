package traader;

public class Post {
    String beskrivelse;
    String mottaker;

    public Post (String beskrivelse, String mottaker){
        this.beskrivelse = beskrivelse;
        this.mottaker = mottaker;
    }

    public String hentMottaker(){
        return mottaker;
    }

}
