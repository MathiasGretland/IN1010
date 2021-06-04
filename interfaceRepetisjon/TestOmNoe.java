package interfaceRepetisjon;

import java.util.Scanner;

public class TestOmNoe {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        String kekw = tastatur.nextLine();
        System.out.println("Dette var kult");
        System.out.println(kekw);
        System.out.println("Tast inn et tall");
        int tall = tastatur.nextInt();
        System.out.println("Det tallet var gay");
        System.out.println(tall);

    }
}
