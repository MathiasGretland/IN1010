package lenkelister;

public class DobbelLenkelisteTemplateFILO <T>{
    private class Node{
        T data;
        Node neste = null;
        Node forrige = null;
        Node(T data){
            this.data = data;
        }
    }

    Node start = null;


    //Metode for å legge til en node først i lista, den gamle start noden blir da den nye start noden sin neste, osv.
    public void settInn(T data){
        Node nyNode = new Node(data);
        if (start == null){
            start = nyNode;
        }
        else {
            Node tmp = start;
            start = nyNode;
            start.neste = tmp;
            tmp.forrige = start;
        }
    }

    //Henter ut det første elemtet i lista, aka det elementet som ble nyligst lagt til.
    public T hentUt(){
        if (start == null){
            return null;
        }
        else {
            Node tmp = start;
            start = start.neste;
            start.forrige = null;
            return tmp.data;
        }

    }

    public void skrivUtAlle(){
        Node iter = start;
        while (iter != null){
            System.out.println(iter.data);
            iter = iter.neste;
        }
    }


    public static void main(String[] args) {
        DobbelLenkelisteTemplateFILO<String> dobbelStringListe = new DobbelLenkelisteTemplateFILO<>();

        dobbelStringListe.settInn("KEKW");
        dobbelStringListe.settInn("XD");
        dobbelStringListe.settInn("SWAG");
        dobbelStringListe.settInn("420");


        dobbelStringListe.skrivUtAlle();

        dobbelStringListe.hentUt();

        System.out.println();
        dobbelStringListe.skrivUtAlle();


    }
}
