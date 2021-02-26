package oblig3;

class Lenkeliste<T> implements Liste<T>{

    private Node start = null;

    class Node {
        Node neste = null;
        T data;
        Node(T x) {
            data = x;
        }
    }

    /**
     * Metoden stoerrelse() går igjennom hvor mange elementer det finnes i lenkelisten. Returnerer et heltall.
     */
    @Override
    public int stoerrelse() {
        int teller = 0;
        Node peker = start;
        while (peker != null){
            teller++;
            peker = peker.neste;
        }
        return teller;
    }

    /**
     * Metoden leggTil(pos, x) legger inn et nytt element i listen på angitt posisjon.
     * De resterende elementene i listen får dermed en høyrere posisjon.
     */
    @Override
    public void leggTil(int pos, T x) {
        if (pos < 0 || pos > stoerrelse())
            throw new UgyldigListeIndeks(-1);

        /**
         * Hvis pos er lik 0 eller størrelsen på listen er lik 0, så skal det opprettes et nytt element på plass 0
         * Hvis pos er lik størrelsen -1 på lenkelisten, altså det siste elementet. Legger til et Node objekt bakerst.
         * Hvis ikke kjører den gjennom en for loop til den finner den riktige plasseringa til hvor det skal legges til en ny Node.
         */
        if (pos == 0 || stoerrelse() == 0){
            Node nyNode = new Node(x);
            Node tmp = start;
            start = nyNode;
            nyNode.neste = tmp;
        }
        else if (pos == stoerrelse()-1){
            Node p = start;
            while (p.neste != null){
                p = p.neste;
            }
            p.neste = new Node(x);
        }
        else {
            Node p = start;
            for (int i = 0; i < pos-1; i++){
                p = p.neste;
            }
            Node nyNode = new Node(x);
            nyNode.neste = p.neste;
            p.neste = nyNode;

        }

    }

    /**
     * Metoden leggTil(x) skal sette inn et element på slutten av listen
     */
    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);
        /**
         * Hvis start ikke har opprettet en node, gjør den det.
         * Hvis det finnes en nøde går den gjennom listen til den finner en Node som ikke har noen nestepeker, og opretter et nytt Node objekt.
         */
        if (start == null) {
            start = ny;
            return;
        } else {
            Node p = start;
            while (p.neste != null){
                p = p.neste;
            }
            p.neste = new Node(x);
        }

    }

    /**
     * Metoden sett skal sette inn elementet på den angitte posisjonen og overskrive det som var der fra før.
     */
    @Override
    public void sett(int pos, T x) {
        if (pos < 0 || pos >= stoerrelse())
            throw new UgyldigListeIndeks(-1);

        /**
         * Hvis pos er lik 0, skal den ta den første noden og oppdatere dataen.
         * Hvis pos er lik størrelsen -1 på lenkelisten, altså det siste elementet. Oppdaterer den dataen.
         * Hvis ikke kjører den gjennom en for loop til den finner den riktige noden som den skal oppdatere.
         */
        if (pos == 0){
            Node p = start;
            p.data = x;
        }
        else if (pos == stoerrelse()-1){
            Node p = start;
            while (p.neste != null){
                p = p.neste;
            }
            p.data = x;
        }
        else {
            Node p = start;
            //Int i må være lik 1 ellers blir posisjoneringa feil
            for (int i = 0; i < pos; i++) {
                p = p.neste;
            }
            p.data = x;
        }

    }

    /**
     *Metoden hent, henter ut elementet uten å fjerne den fra lista, og returnerer dataen.
     */
    @Override
    public T hent(int pos) {
        if (pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeIndeks(-1);
        }

        /**
         * Finner det første elementet og kjører en for loop til den angitte posisjonen, og returnerer dataen.
         */
        Node hentNode = start;
        for (int i = 0; i < pos; i++){
            hentNode = hentNode.neste;
        }
        return hentNode.data;
    }

    /**
     * Metoden fjern(pos) fjernet elementet som er oppgit i pos.
     * Etterfulgt at elementene kommer et hakk forover i listen (de får en lavere posisjon)
     */
    @Override
    public T fjern(int pos) {
        if (pos < 0 || pos >= stoerrelse())
            throw new UgyldigListeIndeks(-1);

        /**
         * Hvis pos er lik 0, kjører vi den andre fjern() metoden.
         * Hvis ikke, finner den posisjonen til den som skal fjernes, fjerner den, får den som peker på den som blir fjernet til å peke på den neste og returnerer den som ble fjernet.
         */
        if (pos==0){
            return fjern();
        } else {
            Node p = start;
            for (int i = 0; i < pos-1; i++){
                p = p.neste;
            }
            Node tmp = p;
            T fjernet = p.neste.data;
            tmp.neste = p.neste.neste;
            return fjernet;
        }

    }

    /**
     * Metoden fjern, fjerner og returnerer det første elementet på starten av lista
     */
    @Override
    public T fjern() {
        if (stoerrelse() <= 0)
            throw new UgyldigListeIndeks(-1);
        /**
         * tmp holder på dataen til elementet som blir fjernet.
         * Fjern blir satt til start, også blir start satt til fjern sin neste, slik at det blir riktig rekkefølge.
         */
        Node tmp = start;
        Node fjern = start;
        start = fjern.neste;
        return tmp.data;
    }
}
