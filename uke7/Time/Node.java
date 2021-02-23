package uke7.Time;

class Node<T>{

    private Node<T> neste;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public void settNeste(Node<T> neste){
        this.neste = neste;
    }

    public Node<T> hentNeste(){
        return neste;
    }

    public T hentData(){
        return data;
    }

    @Override
    public String toString(){
        Node<T> tmp = this;
        String tmpString = "";
        while(tmp != null){
            tmpString += tmp.hentData() + " --> ";
            tmp = tmp.hentNeste();
        }
        return tmpString;
    }
}