package uke2;
import java.util.Scanner;

public class Differanse {
    public static void main(String[] args) {
        String lest;
        int x;
        int y;

        Scanner tastatur = new Scanner(System.in);

        System.out.println("Oppgi verdien til x: ");
        lest = tastatur.nextLine();
        x = Integer.parseInt(lest);

        System.out.println("Oppgi verdien til y: ");
        lest = tastatur.nextLine();
        y = Integer.parseInt(lest);

        System.out.println("Differansen mellom x og y er " + (x-y));
    }
}
