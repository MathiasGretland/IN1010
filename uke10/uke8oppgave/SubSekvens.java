package uke10.uke8oppgave;

public class SubSekvens {
    private String subsekvens;
    private int antall = 1;

    public SubSekvens(String subsekvens){
        this.subsekvens = subsekvens;
    }

    public String hentSubsekvens(){
        return subsekvens;
    }

    public void settSubsekvens(String nySubsekvens){
        subsekvens = nySubsekvens;
    }

    public int hentAntall(){
        return antall;
    }

    public void leggTilAntall(int nyttAntall){
        antall += nyttAntall;
    }
}
