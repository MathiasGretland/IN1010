package utfordringer;

import java.util.Scanner;

public class KoProgram {
    public static void main(String[] args) {
        String tekst = "**MENY FOR BILLETTSYSTEM** \n1 - Trekk ny kølapp. \n2 - betjen kunde. \n3 - Print antall kunder i kø. \n4 - Avslutt. \n";
        Scanner tastatur = new Scanner(System.in);
        KoSystem koSystem = new KoSystem();
        System.out.println(tekst);
        int input = tastatur.nextInt();

        while (input != 4){
            if (input == 1){
                koSystem.trekkKoLapp();
            }
            else if (input == 2){
                koSystem.betjenKunde();
            }
            else if (input == 3){
                koSystem.printKunderIKo();
            }
            else {
                System.out.println("Ugyldig input!");
            }
            System.out.println();
            System.out.println();
            System.out.println(tekst);
            input = tastatur.nextInt();
        }
        System.out.println("Programmet er avsluttet.");
    }
}
