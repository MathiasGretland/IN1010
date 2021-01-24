package uke1;

import java.util.Scanner;

public class Hovedprogram {
    public static void main(String[] args) {

        Scanner minScanner = new Scanner(System.in);
        System.out.println("Hei, hva heter du?");

        String svarFraBruker = minScanner.nextLine();
        System.out.println("Hei " + svarFraBruker + "! Velkommen til IN1010!");
    }
}