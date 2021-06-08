package lenkelister;

public class GeneriskStabel <T>{
    private Node start;

    public void leggPaa(T k){
        if (erTom()){
            start = new Node(k);
        } else {
            Node midl = start;
            start = new Node(k);
            start.neste = midl;
        }
    }

    public T taAv(){
        if (erTom()){
            return null;
        }
        Node midl = start;
        start = start.neste;
        return midl.data;
    }

    public boolean erTom(){
        return start == null;
    }


    private class Node{
        private T data;
        private Node neste;

        private Node(T data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        GeneriskStabel<String> stabel = new GeneriskStabel<String>();
        stabel.leggPaa("foobar");
        stabel.leggPaa("bazar");
        stabel.leggPaa("baz");
        stabel.leggPaa("bar");
        stabel.leggPaa("Foo");
        String resultat = "";
        while (!stabel.erTom())
            resultat += stabel.taAv() + " ";
        System.out.printf("Resultatet er: '%s'\n", resultat);
    }
}
