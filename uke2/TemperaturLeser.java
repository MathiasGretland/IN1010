package uke2;

import java.util.Scanner;
import java.io.File;

public class TemperaturLeser {
    public static void main(String[] args) throws Exception {
        Scanner fil = new Scanner(new File("uke2/Temperatur.txt"));
        String[] temperaturer  = new String[12];
        int teller = 0;

        while (fil.hasNextLine()) {
            temperaturer[teller] = fil.nextLine();
            teller++;
        }

        for (int i = 0; i < temperaturer.length; i++) {
            System.out.println(temperaturer[i]);
        }
    }
}
