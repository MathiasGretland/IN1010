package uke12;

public class TestLenkeliste {
    public static void main(String[] args) {
        Lenkeliste lenkeliste = new Lenkeliste();
        lenkeliste.leggTil(12);
        lenkeliste.leggTil(14);
        lenkeliste.leggTil(1);
        lenkeliste.leggTil(2);
        lenkeliste.leggTil(8);

        System.out.println(lenkeliste.hent(0));
        System.out.println(lenkeliste.hent(1));
        System.out.println(lenkeliste.hent(2));
        System.out.println(lenkeliste.hent(3));
        System.out.println(lenkeliste.hent(4));

        System.out.println();

        lenkeliste.skrivUt();

        System.out.println();
        System.out.println(lenkeliste.stoerrelse());
        System.out.println();
        System.out.println(lenkeliste.stoerrelseRekursivt());

        System.out.println();
        lenkeliste.skrivUtRekursivtBaklengs();

        System.out.println();
        lenkeliste.skrivUtRekursivt();
    }
}
