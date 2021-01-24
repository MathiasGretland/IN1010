package uke2;

import java.util.Scanner;

public class HarKjoretidsfeil {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Scanner tastatur = new Scanner(System.in);

        System.out.println("Tast inn to heltall");
        x = Integer.parseInt(tastatur.nextLine());
        y = Integer.parseInt(tastatur.nextLine());

        System.out.println("Summen av tallene er: " + (x + y));
    }
}

