package uke7.Time;

class Operasjonsliste<T> {

    private Node forste;

    class Node{
        Node neste;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    public void settInnForst(T data){
        Node nyNode = new Node(data);
        nyNode.neste = forste;
        forste = nyNode;
    }

    public void leggTilOperasjonsliste(Operasjonsliste<T> nyListe){
        if(nyListe.equals(this)){
            return;
        }
        if(forste == null){
            forste = nyListe.forste;
            return;
        }

        Node tmp = forste;
        while(tmp.neste != null){
            tmp = tmp.neste;
        }
        tmp.neste = nyListe.forste;
    }

    public void settInnEtterElement(T element, T nyttElement){

        Node tmp = forste;
        while(tmp != null){
            if(tmp.data.equals(element)){
                Node nyNode = new Node(nyttElement);
                nyNode.neste = tmp.neste;
                tmp.neste = nyNode;
                return;
            }
            tmp = tmp.neste;
        }

    }

    public void fjernAnnenHver(){
        Node tmp = forste;
        while(tmp != null && tmp.neste != null){
            tmp.neste = tmp.neste.neste;
            tmp = tmp.neste;
        }
    }

    @Override
    public String toString(){
        Node tmp = forste;
        String tmpString = "";
        while(tmp != null){
            tmpString += tmp.data + " --> ";
            tmp = tmp.neste;
        }
        return tmpString;
    }

}