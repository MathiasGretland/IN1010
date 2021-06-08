package lenkelister;

public class DobbelLenke <T>{

    Node start = null;

    private class Node{
        T data;
        Node neste = null;
        Node forrige = null;
        Node(T data){
            this.data = data;
        }
    }

    public int stoerrelse() {
        int teller = 0;
        Node peker = start;
        while (peker != null){
            teller++;
            peker = peker.neste;
        }
        return teller;
    }

    public void settInn(T element){
        Node nyNode = new Node(element);
        if (start == null){
            start = nyNode;
        }
        else {
            Node node = start;
            while (node.neste != null){
                node = node.neste;
            }
            node.neste = nyNode;
            node.forrige = node;
        }
    }

    //dank
    public void skrivUt(){
        Node node = start;
        while (node != null){
            System.out.println(node.data);
            node = node.neste;
        }
    }

    public static void main(String[] args) {
        DobbelLenke<String> daddy = new DobbelLenke<>();

        daddy.settInn("kebab");
        daddy.settInn("ost");
        daddy.settInn("hamburger");
        daddy.skrivUt();
        System.out.println(daddy.stoerrelse());
    }
}
