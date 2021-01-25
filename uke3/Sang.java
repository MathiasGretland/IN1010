package uke3;

public class Sang {
    private String[] artister;
    private String tittel;

    public Sang(String tittel, String [] artister){
        this.artister = artister;
        this.tittel = tittel;
    }

    public void spill() {
        System.out.println("Spiller " + tittel);
    }

    public boolean sjekkArtister(String navn) {
        for (String artist : artister){
            if (artist.toLowerCase().equals(navn.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public String hentTittel(){
        return tittel;
    }

    public String[] hentArtister(){
        return artister;
    }

    public String toString(){
        return tittel + " av " + artister[0];
    }


}
