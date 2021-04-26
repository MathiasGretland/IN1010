package V2018;

public class Prioritetskoe<T> {
    private class Node {
        T data;
        int prioritet;
        Node neste = null;

        Node(T inn, int prio){
            data = inn;
            prioritet = prio;
        }
    }
    private Node start = null;

    void settInn(T inn, int prio){
        Node ny = new Node(inn, prio);
        if (start == null){
            start = ny;
        }
        else if(ny.prioritet <= start.prioritet){
            ny.neste = start;
            start = ny;
        }
        else {
            Node p = start;
            while (p.neste != null && p.prioritet< ny.prioritet){
                p = p.neste;
            }
            ny.neste = p.neste;
            p.neste = ny;
        }
    }

    T taUt(){
        if (start == null){
            return null;
        }

        T tasUt = start.data;
        start = start.neste;
        return tasUt;
    }

    int antall(){
        int teller = 0;
        Node peker = start;
        while (peker != null){
            teller++;
            peker = peker.neste;
        }
        return teller;
    }

}
