package uke2;

import java.util.Scanner;
import java.io.File;

public class Linjenummer {
    public static void main(String[] args) throws Exception{
        Scanner fil = new Scanner(new File("uke2/Sang.txt"));
        String linje = "";

        for (int i = 0; fil.hasNextLine(); i++){
            linje = fil.nextLine();
            System.out.println("# " + i + ": " + linje);
        }
    }
}
