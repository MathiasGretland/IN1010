package uke5;

public class Emne {
    String navn;
    int eksamensdato;

    public Emne(String navn, int eksamensdato){
        this.navn = navn;
        this.eksamensdato = eksamensdato;
    }

    public int dagerTilEksamen(){
        return eksamensdato;
    }
}
