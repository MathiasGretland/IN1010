package oblig3;

public class Stabel <T> extends Lenkeliste <T>{

    /**
     * Metoden leggPaa(x) legger til et element på slutten av lista.
     * Bruker enkelt bare leggTil(x) metoden.
     */
    public void leggPaa(T x){
        this.leggTil(x);
    }

    /**
     * Metoden taAv() fjerner det siste elemntet i lista.
     * Returnerer et element.
     */
    public T taAv(){
        return fjern(stoerrelse()-1);
    }
}
