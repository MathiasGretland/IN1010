package repetisjon;

import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String> {
    private String[] array;
    private int antallStrenger;
    private int storrelse = 0;

    EnkelArrayListe(int antallStrenger){
        this.antallStrenger = antallStrenger;
        array = new String[antallStrenger];
    }

    private void leggTil(String strenge){
        if (storrelse >= antallStrenger){
            System.out.println("FOR MANGE STRENGER!");
        }
        else {
            array[storrelse++] = strenge;
        }
    }

    public void skrivUtAlle(){
        for (String e : array){
            System.out.println(e);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListeIterator();
    }

    public static void main(String[] args) {
        EnkelArrayListe liste = new EnkelArrayListe(4);

        liste.leggTil("kekw");
        liste.leggTil("XD");
        liste.leggTil("lol");
        liste.leggTil("hahha");

        liste.skrivUtAlle();
    }

    private class ListeIterator implements Iterator<String>{
        private int gjeldendeIndeks = 0;

        @Override
        public boolean hasNext() {
            return gjeldendeIndeks < storrelse;
        }

        @Override
        public String next() {
            return array[gjeldendeIndeks++];
        }
    }
}
