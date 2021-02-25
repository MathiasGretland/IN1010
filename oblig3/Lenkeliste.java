package oblig3;

public class Lenkeliste<T> implements Liste<T>{

    private Node start;

    class Node {
        Node neste;
        T data;

        Node(T x) {
            data = x;
        }
    }

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

    @Override
    public void leggTil(int pos, T x) {
        if (pos < 0 || pos > stoerrelse())
            throw new UgyldigListeIndeks(-1);


        //Hvis lista er tom, så er det bare å kjøre den andre leggTil metoden
        if (pos == 0 || stoerrelse() == 0){
            leggTil(x);
        } else {
            Node p = start;
            //Int i må være lik 1 ellers blir posisjoneringa feil
            for (int i = 1; i < pos; i++){
                p = p.neste;
            }
            Node nyNode = new Node(x);
            nyNode.neste = p.neste;
            p.neste = nyNode;

        }

    }

    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);
        ny.neste = start;
        start = ny;
    }

    @Override
    public void sett(int pos, T x) {
        if (pos < 0 || pos > stoerrelse())
            throw new UgyldigListeIndeks(-1);

        //FEIL
        if (pos == 0){
            Node p = start;
            p.neste.data = x;
            start = p;
        } else {
            Node p = start;
            //Int i må være lik 1 ellers blir posisjoneringa feil
            for (int i = 1; i < pos; i++) {
                p = p.neste;
            }
            p.neste.data = x;
        }

    }

    @Override
    public T hent(int pos) {
        Node hentNode = start;
        for (int i = 0; i<pos; i++){
            hentNode = hentNode.neste;
        }
        return hentNode.data;
    }

    @Override
    public T fjern(int pos) {
        if (pos < 0 || pos > stoerrelse() || stoerrelse() <= 0)
            throw new UgyldigListeIndeks(-1);

        //FEIL
        if (pos == 0){
            Node p = start;

            Node fjernetNode = p;
            p.neste = fjernetNode.neste;
            return fjernetNode.data;
        } else {
            Node p = start;
            for (int i = 1; i < pos; i++){
                p = p.neste;
            }
            Node fjernetNode = p.neste;
            p.neste = fjernetNode.neste;
            return fjernetNode.data;
        }
    }

    @Override
    public T fjern() {
        if (stoerrelse() <= 0)
            throw new UgyldigListeIndeks(-1);

        T data = start.data;
        start = start.neste;

        return data;
    }

    public String toString(){
        if (start == null){
            return "Det finnes ingen elementer";
        }

        return "SWAG";
    }
}
