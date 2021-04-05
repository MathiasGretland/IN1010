package uke10Repetisjon;

import java.util.Scanner;

public class TradKlokke {
    public static void main(String[] args) {
        Scanner minInn = new Scanner(System.in);
        Runnable kjor = new KlokkeKjorer();
        Thread traad = new Thread(kjor);
        System.out.println(" Stoppeklokke ");
        System.out.println(" Tast ENTER for å stoppe og starte");
        minInn.nextLine();
        traad.start();
        minInn.nextLine();
        ((KlokkeKjorer)kjor).stopp();
        System.out.println("Cya");
    }
}
