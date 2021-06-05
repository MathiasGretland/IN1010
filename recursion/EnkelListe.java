package recursion;

public class EnkelListe {
    private Node start = null;

    public void settInnForan(String nyttInnhold) {
        Node ny = new Node(nyttInnhold);
        if (start == null){
            start = ny;
        }else {
            ny.neste = start;
            start = ny;
        }
    }

    public void skrivUt() {
        skrivUtBaklengs(start);
        /*
        Node tmp = start;
        while (tmp != null) {
            System.out.println(tmp.innhold);
            tmp = tmp.neste;
        }

         */
    }

    private void skrivUtBaklengs(Node n){
        Node iter = n;
        if (iter == null){
            return;
        }
        else {
            skrivUtBaklengs(iter.neste);
            System.out.println(iter.innhold);
        }
    }

    public static void skrivUtBinaer(int n){
        if (n == 0){
            System.out.println(0);;
        }else {
            if (n > 1){
                System.out.println(n/2);
            }
            System.out.println(n%2);
        }
    }

    private class Node {
        private String innhold;
        private Node neste;

        Node(String s) {
            innhold = s;
        }
    }
}
