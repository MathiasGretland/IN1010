package V2018;

public class Prioritetskoe <T> {
    private class Node{
        T data;
        int prioritet;
        Node neste = null;

        Node (T data, int prio){
            this.data = data;
            prioritet = prio;
        }
    }

    Node start = null;

    public void settInn(T inn, int prio){
        Node nyNode = new Node(inn, prio);
        if (start == null){
            start = nyNode;
            return;
        }
        if (start.prioritet > nyNode.prioritet){
            Node gamleStart = start;
            nyNode = start;
            nyNode.neste = gamleStart;
            return;
        }

        Node iterNode = start;
        while (iterNode.neste != null && nyNode.prioritet > iterNode.neste.prioritet){
            iterNode = iterNode.neste;
        }
        nyNode.neste = iterNode.neste;
        iterNode.neste = nyNode;

    }

    public T taUt(){
        if (start == null){
            return null;
        }
        T ut = start.data;
        start = start.neste;
        return ut;
    }

    public int antall(){
        int teller = 0;
        Node peker = start;
        while (peker != null){
            teller++;
            peker = peker.neste;
        }
        return teller;
    }
}
