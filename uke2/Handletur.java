package uke2;

import java.util.Scanner;

public class Handletur {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hei! Velkommen til IFI-butikken.");

        System.out.println("Hvor mange brød vil du ha?");
        int antallBroed = input.nextInt();

        System.out.println("Hvor mange melk vil du ha?");
        int antallMelk = input.nextInt();

        System.out.println("Hvor mange ost vil du ha?");
        int antallOst = input.nextInt();

        System.out.println("Hvor mange yoghurt vil du ha?");
        int antallYoghurt = input.nextInt();

        int sum = antallBroed * 20 + antallMelk * 15 + antallOst * 40 + antallYoghurt * 12;
        System.out.println("Du skal betale: " + sum);
    }
}
