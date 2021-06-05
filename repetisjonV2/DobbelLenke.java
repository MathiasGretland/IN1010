package repetisjonV2;

public class DobbelLenke <T>{
    private class Node{
        T data;
        Node neste;
        Node forrige;
        Node (T data){
            this.data = data;
        }
    }

    Node start = null;

    public void settInn(T elemenet){
        Node nyNode = new Node(elemenet);
        if (start == null){
            start = nyNode;
        }
        Node iter = start;
        while (iter.neste != null){
            iter = iter.neste;
        }
        iter.neste = nyNode;
        nyNode.forrige = iter;
    }

    public int storrelse(){
        int teller = 0;
        Node iter = start;
        while (iter != null){
            iter = iter.neste;
            teller++;
        }
        return teller;
    }
}
