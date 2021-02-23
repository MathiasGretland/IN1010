package oblig3;

public class Test {
    public static void main(String[] args) {
        Lenkeliste swag = new Lenkeliste();
        swag.leggTil(3);
        swag.leggTil(3);
        swag.fjern();
        System.out.println(swag.stoerrelse());
    }
}
