package oblig5;

public class Subsekvens {
    private String subsekvens;
    private int antall = 1;

    public Subsekvens(String subsekvens){
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