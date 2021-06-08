package lenkelister;

import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String>{
    String[] stringArray;
    int lengdePaaArray;
    int storrelse = 0;

    EnkelArrayListe(int lengdePaaArray){
        this.lengdePaaArray = lengdePaaArray;
        stringArray = new String[lengdePaaArray];
    }

    public void leggTilString(String streng){
        /*
        stringArray[storrelse] = streng;
        storrelse++;
        */
        int teller = 0;
        while (stringArray[teller] != null){
            teller++;
        }
        stringArray[teller] = streng;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    private class ListeIterator implements Iterator<String>{
        int index = 0;

        @Override
        public boolean hasNext() {
            if (next() != null){
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            return stringArray[index++];
        }
    }

    public static void main(String[] args) {
        EnkelArrayListe lol = new EnkelArrayListe(12);
        lol.leggTilString("kekw");
        lol.leggTilString("dank");
        for (String s : lol.stringArray){
            if (s != null){
                System.out.println(s);
            }
        }
    }
}
