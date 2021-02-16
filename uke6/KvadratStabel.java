package uke6;

import uke3.Kvadrat;

public class KvadratStabel {
    private Node start;


    public void leggPaa(Kvadrat kvadrat){
        if (erTom()){
            start = new Node(kvadrat);
        } else {
            Node mid1 = start;
            start = new Node(kvadrat);
            start.neste = mid1;
        }
    }

    public Kvadrat taAv(){
        if (erTom()){
            return null;
        } else {
            Node mid1 = start;
            start = start.neste;
            return mid1.data;
        }
    }

    public boolean erTom(){
        return  start == null;
    }

    private class Node{
        private Kvadrat data;
        private Node neste;

        private Node(Kvadrat data){
            this.data = data;
        }
    }
}
