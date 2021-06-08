package lenkelister;

public class EnkelLenkelisteTemplate<T> {
    private class Node{
        T data;
        Node neste;
        private Node(T data){
            this.data = data;
        }
    }

    //Noden som blir brukt i FirstInLastOut
    Node startFILO = null;
    //Noden som blir brukt i FirstInFirstOut
    Node startFIFO = null;

    //Altså her legger vi til en node blir den til startFILO noden, vi altså legger den til først i lista.
    public void settInnFirstInLastOut(T data){
        Node nyNode = new Node(data);
        if (startFILO == null){
            startFILO = nyNode;
        }else {
            Node gamle = startFILO;
            startFILO = nyNode;
            startFILO.neste = gamle;
        }
    }

    public void skrivUtAlleFirstInLastOut(){
        Node iter = startFILO;
        while (iter != null){
            System.out.println(iter.data);
            iter = iter.neste;
        }
    }

    //Henter ut og fjerner den første noden, altså startFILO, samtidig som at startFILO blir til neste:
    public T hentUtFirstInLastOut(){
        if (startFILO == null){
            return null;
        }else{
            Node tmp = startFILO;
            startFILO = startFILO.neste;
            return tmp.data;
        }
    }

    //FirstInFirstOut så er man nødt til å legge noden til på slutten av lista og ikke starten.
    public void settInnFirstInFirstOut(T data){
        Node nynode = new Node(data);
        if (startFIFO == null){
            startFIFO = nynode;
        }else {
            Node iter = startFIFO;
            while (iter.neste != null){
                iter = iter.neste;
            }
            iter.neste = nynode;
        }
    }

    //Henter ut og fjerner det siste elementet i lenkelisten, altså det som ble lagt inn nyligst.
    public T hentUtFirstInFirstOut(){
        if (startFIFO == null){
            return null;
        }
        if (startFIFO.neste == null){
            Node gamleSiste = startFIFO;
            startFIFO = null;
            return gamleSiste.data;
        }
        else {
            Node tmp = startFIFO;
            while (tmp.neste.neste != null){
                tmp = tmp.neste;
            }
            Node fjernes = tmp.neste;
            tmp.neste = null;
            return fjernes.data;
        }
    }

    public void skrivUtAlleFirstInFirstOut(){
        Node iter = startFIFO;
        while (iter != null){
            System.out.println(iter.data);
            iter = iter.neste;
        }
    }




    //Skriver de bare ut
    public static void main(String[] args) {
        EnkelLenkelisteTemplate<Katt> katteliste1 = new EnkelLenkelisteTemplate<>();
        /*
        katteliste1.settInnFirstInLastOut(new Katt("TEEMO", 12));
        katteliste1.settInnFirstInLastOut(new Katt("SKRT", 12));
        katteliste1.settInnFirstInLastOut(new Katt("DAB", 18));
        katteliste1.skrivUtAlleFirstInLastOut();
        System.out.println();
        System.out.println(katteliste1.hentUtFirstInLastOut());
        System.out.println();
        katteliste1.skrivUtAlleFirstInLastOut();

         */


        EnkelLenkelisteTemplate<Katt> katteliste2 = new EnkelLenkelisteTemplate<>();
        katteliste2.settInnFirstInFirstOut(new Katt("TEEMO", 12));
        katteliste2.settInnFirstInFirstOut(new Katt("SKRT", 12));
        katteliste2.settInnFirstInFirstOut(new Katt("DAB", 18));
        katteliste2.settInnFirstInFirstOut(new Katt("KEKW", 20));

        katteliste2.skrivUtAlleFirstInFirstOut();

        System.out.println();
        System.out.println(katteliste2.hentUtFirstInFirstOut());

        System.out.println();
        katteliste2.skrivUtAlleFirstInFirstOut();
    }


}
