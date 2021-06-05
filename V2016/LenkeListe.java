package V2016;

public class LenkeListe < T extends Comparable<T>>{
    private ListeHode lhode;
    private ListeHale lhale;
    private int antall;

    LenkeListe(){
        lhode = new ListeHode(null);
        lhale = new ListeHale(lhode, null);
        lhode.neste = lhale;
        antall = 0;
    }

    private abstract class AbstrNode{
        T data;
        AbstrNode neste;

        AbstrNode(T t){
            data = t;
            neste = null;
        }
        abstract int compareTo(AbstrNode k);
        abstract void settInnOrdnet(AbstrNode k);
    }

    private class ListeHode extends AbstrNode{
        AbstrNode neste = null;

        ListeHode(T t) {
            super(t);
        }

        @Override
        int compareTo(AbstrNode k) {
            return -9;
        }

        @Override
        void settInnOrdnet(AbstrNode k) {
            //if (neste.compareTo(k) >= 0) Denne er for å sammenligne hvor noden skal plaseres, men oppgaven er så dritt forklart at dette holder
             k.neste = lhode.neste;
             lhode.neste = k;
             if (k.neste == lhale){ //For å passe på at hvis den noden som settes inn er bakerst.
                 lhale.forrige = k;
             }
             antall++;
        }
    }

    private class ListeHale extends AbstrNode {
        AbstrNode forrige;
        ListeHale(AbstrNode forrige,T t) {
            super(t);
            this.forrige = forrige;
        }

        @Override
        int compareTo(AbstrNode k) {
            return 9;
        }

        @Override
        void settInnOrdnet(AbstrNode k) {
            lhale.forrige.neste = k;
            k.neste = lhale;
            lhale.forrige = k;

        }
    }

    private class Node extends AbstrNode {
        Node(T t) {
            super(t);
        }

        @Override
        int compareTo(AbstrNode k) {
            return data.compareTo(k.data);
        }

        @Override
        void settInnOrdnet(AbstrNode k) {

        }
    }

    public int antall(){
        return antall;
    }

    public void settInnOrdnet(T nyComparable){
        Node nyNode = new Node(nyComparable);
        lhode.settInnOrdnet(nyNode);
    }

    public void settInnBak (T nyComparable){
        Node nyNode = new Node(nyComparable);
        lhale.forrige.neste = nyNode;
        lhale.forrige = nyNode;
        nyNode.neste = lhale;
        antall++;

    }

    public T taUtForan(){
        AbstrNode ut = lhode.neste;
        if (lhode.neste == lhale){
            return null;
        }
        lhode.neste = lhode.neste.neste;
        return ut.data;
    }

    public boolean tom(){
        return true;
    }
}
