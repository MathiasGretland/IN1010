package uke2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LesFraFil {
    public static void main(String[] args) {
        System.out.println("Hello world");
        File minFil = new File("uke2/hei.txt");

        Scanner sc = null;

        try {
            sc = new Scanner(minFil);

        } catch (FileNotFoundException e) {
            System.out.println("Opps noe gikk galt!");
            System.out.println(e);
            System.exit(0);
        }
        if (sc == null){
            System.out.println("La oss gå videre");
        }

        System.out.println(sc.nextLine());
        System.out.println(sc.nextInt());
        System.out.println(sc.nextLine());
    }
}
