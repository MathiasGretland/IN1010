package oblig2;

public class Hovedprogram {
    public static void main(String[] args) {
        /**
        * Opprettelse av hver klasse.
        * Note: Jeg kan ikke noe om legemidler, så pris, virkestoff og styrke er bare tilfeldige tall.
         */


        Lege anton = new Lege("Anton");
        Spesialist kristian = new Spesialist("Kristian", "RY2731824");
        Narkotisk morfin = new Narkotisk("Morfin", 1200,1,20.5,10);
        Vanlig apixaban = new Vanlig("Apixaban", 300,8, 2.3);
        Vanedannende opioder = new Vanedannende("Opioder", 1800, 3, 25.3, 12);
        BlaaResept opioderResept = new BlaaResept(opioder, kristian, 17, 8);
        Militerresept morfinResept = new Militerresept(morfin, kristian, 25, 7);
        PResept apixabanResept = new PResept(apixaban, anton, 75);

        /**
        * Skriver ut informasjon om hvert enkelt objekt.
         */
        System.out.println(anton.toString());
        System.out.println();
        System.out.println(kristian.toString());
        System.out.println();
        System.out.println(morfin.toString());
        System.out.println();
        System.out.println(apixaban.toString());
        System.out.println();
        System.out.println(opioder.toString());
        System.out.println();
        System.out.println(opioderResept.toString());
        System.out.println();
        System.out.println(morfinResept.toString());
        System.out.println();
        System.out.println(apixabanResept.toString());
    }
}
