package repetisjonV2;

public class KvadratStabel {
    private class Node {
        Kvadrat data;
        Node neste;

        Node(Kvadrat data){
            this.data = data;
        }
    }

    Node start = null;

    public void leggPaa(Kvadrat k){
        if (start == null){
            start = new Node(k);
        }
        Node midl = start.neste;
        Node nyNode = new Node(k);
        start.neste = nyNode;
        nyNode.neste = midl;
    }

    public Kvadrat taAv(){
        if (start == null){
            return null;
        }
        Node midl = start;
        start = start.neste;
        return midl.data;
    }

    public boolean erTom(){
        if (start == null){
            return true;
        }
        else {
            return false;
        }
    }

}
