package lenkelister;

public class DobbelLenkelisteTemplateFIFO <T>{
    private class Node{
        T data;
        Node neste = null;
        Node forrige = null;
        Node(T data){
            this.data = data;
        }
    }

    Node start = null;

    //FirstInFirstOut så er man nødt til å legge noden til på slutten av lista og ikke starten.
    public void settInn(T data){
        Node nyNode = new Node(data);
        if (start == null){
            start = nyNode;
        }else {
            Node iter = start;
            while (iter.neste != null){
                iter = iter.neste;
            }
            iter.neste = nyNode;
            nyNode.forrige = iter;
        }
    }

    //Henter ut og fjerner det siste elementet i lenkelisten, altså det som ble lagt inn nyligst.
    public T hentUt(){
        if (start == null){
            return null;
        }
        else {
            Node iter = start;
            while (iter.neste != null){
                iter = iter.neste;
            }
            Node tmp = iter.forrige;
            tmp.neste = null;
            return iter.data;
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
        DobbelLenkelisteTemplateFIFO<String> dobbelStringListe = new DobbelLenkelisteTemplateFIFO();

        dobbelStringListe.settInn("KEKW");
        dobbelStringListe.settInn("XD");
        dobbelStringListe.settInn("SWAG");
        dobbelStringListe.settInn("420");

        dobbelStringListe.skrivUtAlle();

        System.out.println();
        System.out.println(dobbelStringListe.hentUt());
        System.out.println();
        dobbelStringListe.skrivUtAlle();

    }

}
