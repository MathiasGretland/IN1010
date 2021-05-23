package repetisjon;

public class KvadratStabel {
    private Node start;

    public void leggPaa(Kvadrat k){
        if (erTom()){
            start = new Node(k);
        } else {
            Node midl = start;
            start = new Node(k);
            start.neste = midl;
        }
    }

    public Kvadrat taAv(){
        if (erTom()){
            return null;
        }
        Node midl = start;
        start = start.neste;
        return midl.data;
    }

    public boolean erTom(){
        return start == null;
    }


    private class Node{
        private Kvadrat data;
        private Node neste;

        private Node(Kvadrat data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        KvadratStabel stabel = new KvadratStabel();
        stabel.leggPaa(new Kvadrat(1));
        stabel.leggPaa(new Kvadrat(2));
        stabel.leggPaa(new Kvadrat(3));
        stabel.leggPaa(new Kvadrat(4));
        stabel.leggPaa(new Kvadrat(5));
        stabel.leggPaa(new Kvadrat(6));
        double sum = 0, siste = 0;
        while (!stabel.erTom()){
            Kvadrat k = stabel.taAv();
            sum += k.areal();
            siste = k.areal();
        }
        System.out.println("Summen av kvadratenes areal er "
                + sum);
        System.out.println("Det siste kvadratet i stabelen har areal: "
                + siste);
    }
}

class Kvadrat{
    double lengde;

    public Kvadrat(double lengde){
        this.lengde = lengde;
    }

    public double areal(){
        return lengde*lengde;
    }

    public double omkrets(){
        return 4*lengde;
    }
}
