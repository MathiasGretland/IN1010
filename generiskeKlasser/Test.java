package generiskeKlasser;

public class Test {
    public static void main(String[] args) {
        BeholderTilEn<Bil> bilhus = new BeholderTilEn<>();

        Hund albert = new Hund("Albert");
        Bil mercedes = new Bil("KEKW420");
        Hund trofast = new Hund("Trofast");

        bilhus.settInn(mercedes);

        Hundegard hundene = new Hundegard(50);
        hundene.settInn(albert);
        hundene.settInn(new Hund("MAGNUS"));
        hundene.settInn(new Hund("ALEKSANDER"));
        Hund gneldrebikkje = hundene.taUt();
        System.out.println(hundene.storrelse());
        System.out.println(gneldrebikkje.navn);
        System.out.println(hundene.antall);


    }
}
