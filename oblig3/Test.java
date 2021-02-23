package oblig3;

public class Test {
    public static void main(String[] args) {
        Lenkeliste swag = new Lenkeliste();
        swag.leggTil(3);
        swag.leggTil(4);
        swag.leggTil(7);
        swag.leggTil(10);
        swag.leggTil(2);
        swag.leggTil(1);
        System.out.println(swag.hent(3));
        swag.fjern();
        System.out.println(swag.stoerrelse());
    }
}
