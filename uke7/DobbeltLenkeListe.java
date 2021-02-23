package uke7;

class DobbeltLenketListe<T> {

    Node start = null;
    int antall = 0;
    private class Node<T> {
        T data;
        Node<T> neste = null;
        Node<T> forrige = null;
        Node(T data) {
            this.data = data;
        }
        void settNeste(Node<T> neste) {
            this.neste = neste;
            neste.settForrige(this);
        }
        void settForrige(Node forrige) {
            this.forrige = forrige;
        }
        Node<T> hentNeste() {
            return neste;
        }
        Node<T> hentForrige(){
            return forrige;
        }
        T hentData(){
            return data;
        }
    }



    public void settInn(T element) {
        Node<T> nyNode = new Node<>(element);
        if (antall == 0) { //ingen elementer i listen
            start = nyNode;
        }
        else {
            Node<T> node = start;
            while (node.hentNeste() != null) {
                node = node.hentNeste();
            }
            node.settNeste(nyNode);
            nyNode.settForrige(node);
        }
        antall++;
    }

    public void skrivUt() {
        Node node = start;
        while (node != null) {
            System.out.println(node.hentData());
            node = node.hentNeste();
        }
    }




}