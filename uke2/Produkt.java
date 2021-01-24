package uke2;

import java.util.Scanner;

public class Produkt {
    public static void main(String[] args) {
        int x;
        int y;
        int differanse;

        Scanner tastatur = new Scanner(System.in);

        System.out.println("Oppgi verdien til x: ");
        x = Integer.parseInt(tastatur.nextLine());

        System.out.println("Oppgi verdien til y: ");
        y = Integer.parseInt(tastatur.nextLine());

        System.out.println("Produktet av x og y er " + (x*y));

        differanse = x - y;
        if (differanse > 0){
            System.out.println("Differansen er positiv");
        } else {
            System.out.println("Differansen er negativ");
        }

    }
}
