package oblig3;

public class SortertLenkeliste <T extends Comparable<T>> extends Lenkeliste <T>{

    /**
     * Metoden leggTil(x) setter inn elementene i sortert rekkefølge (fra minst til størst).
     */
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        /**
         * Hvis start ikke har noe element er den nødt til å opprette et.
         */
        if (start == null) {
            start = nyNode;
            return;
        } else {
            Node p = start;
            /**
             * Hvis størrelse er lik 1, kjører den nye if sjekken.
             * Hvis p sin data er større enn x, så vil nyNode settes foran p-
             * Hvis x er større enn p sin data, så vil nyNode være etter p.
             */
            if (stoerrelse() == 1){
                if (p.data.compareTo(x) > 0){
                    nyNode.neste = p;
                    start = nyNode;
                } else {
                    p.neste = nyNode;
                }
            } else {
                /**
                 * Mens p sin neste ikke er null og p sin nestes data er mindre enn x, så looper den til riktig posisjon.
                 * Setter inn nyNode på riktig plass i den sorterte lenketlisten.
                 */
                while (p.neste != null && p.neste.data.compareTo(x) < 0){
                    p = p.neste;
                }
                if (p.neste != null){
                    nyNode.neste = p.neste;
                }
                p.neste = nyNode;
            }
        }
    }

    /**
     * Metoden fjern() Finner det siste elmentet i den sorterte lenkelisten og fjerner den
     * Returnerer det største elmentet i den sorterte lenkelisten
     */
    @Override
    public T fjern(){
        return fjern(stoerrelse()-1);
    }

    /**
     * De nye implementasjonene skal ikke sette inn elementet,
     * men i stedet kun kaste et unntak som finnes i Java fra før av:
     * UnsupportedOperationException (dette trenger ikke å importeres).
     */
    @Override
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }
}
