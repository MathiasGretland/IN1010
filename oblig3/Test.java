package oblig3;

public class Test {
    public static void main(String[] args) {
        Lenkeliste<String> lenkeliste = new Lenkeliste<String>();
        lenkeliste.leggTil("A");
        lenkeliste.leggTil("B");
        lenkeliste.leggTil("C");
        System.out.println(lenkeliste.fjern(1));
        lenkeliste.sett(1,"D");

        System.out.println(lenkeliste.stoerrelse());
        System.out.println(lenkeliste.fjern(0));
        System.out.println(lenkeliste.fjern(0));

    }
}
