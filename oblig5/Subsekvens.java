package oblig5;

/**
 * Klassen Subsekvens oppretter
 */
public class Subsekvens {
    private String subsekvens;
    private int antall = 1;

    /**
     * Konstruktør
     * @param subsekvens String for hvilken subsekvens det er
     */
    public Subsekvens(String subsekvens){
        this.subsekvens = subsekvens;
    }

    /**
     * @return subsekvens
     */
    public String hentSubsekvens(){
        return subsekvens;
    }

    /**
     * @return antall
     */
    public int hentAntall(){
        return antall;
    }

    /**
     * @param nyttAntall Legger til et nytt antall
     */
    public void leggTilAntall(int nyttAntall){
        antall += nyttAntall;
    }
}