package uke1;

import java.util.Scanner;

class LesFraTerminal {
    public static void main(String[] args) {
        int alder;
        String navn, adresse;

        Scanner minInn = new Scanner(System.in);

        System.out.print("Skriv adressen din: ");
        adresse = minInn.nextLine();
        System.out.print("Skriv fornavnet ditt: ");
        navn = minInn.nextLine();
        System.out.print("Skriv alder ");
        alder = minInn.nextInt();

        System.out.println(navn + ", du bor i " + adresse + " og er " + alder + " år");
    }
}