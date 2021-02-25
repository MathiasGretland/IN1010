package oblig3;

public class Test {
    public static void main(String[] args) {
        Lenkeliste swag = new Lenkeliste();

        swag.leggTil(6);
        swag.leggTil(5);
        swag.leggTil(4);
        swag.leggTil(3);
        swag.leggTil(2);
        swag.leggTil(1);
        swag.leggTil(4,80);
        swag.sett(0,20);

        System.out.println(swag.fjern(0));

        System.out.println("Pos 0 " + swag.hent(0));
        System.out.println("Pos 1 " + swag.hent(1));
        System.out.println("Pos 2 " + swag.hent(2));
        System.out.println("Pos 3 " + swag.hent(3));
        System.out.println("Pos 4 " + swag.hent(4));
        System.out.println("Pos 5 " + swag.hent(5));



        System.out.println(swag.stoerrelse() + " kult");
        System.out.println(swag.toString());
    }
}
