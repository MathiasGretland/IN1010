package utfordringer;

public class DobbelLenke <T>{
    private class Node{
        T data;
        Node neste;
        Node forrige;
        Node(T data){
            this.data = data;
        }
    }

    Node start = null;

    public void settInn(T n){
        Node nyNode = new Node(n);
        if (start == null){
            start = nyNode;
        }
        else {
            Node iter = start;
            while (iter.neste != null){
                iter = iter.neste;
            }
            iter.neste = nyNode;
            nyNode.forrige = iter;
        }
    }

    public int storrelse(){
        int teller = 0;
        while (start != null){
            start = start.neste;
            teller++;
        }
        return teller;
    }

    public void skrivUt(){
        Node iter = start;
        while (iter != null){
            System.out.println(iter.data);
            iter = iter.neste;
        }
    }

    public static void main(String[] args) {
        DobbelLenke<Bil> swag = new DobbelLenke<>();
        Bil mercedes = new Bil("KUSH420" ,5);
        Bil toyota = new Bil("SHAGWAGON", 5);
        Bil amg = new Bil("BENZTRUCK", 2);
        Bil kekw = new Bil("DANK", 34);
        swag.settInn(mercedes);
        swag.settInn(toyota);
        swag.settInn(amg);
        swag.settInn(kekw);

        swag.skrivUt();
    }
}
