package uke2;

import java.util.Scanner;
import java.io.File;

public class Gruppeoppmoete {
    private String[] navn = new String[17];
    private boolean[] oppmoete = new boolean[17];
    private int totaltStudenter = 0;

    public void lesInnFil(String filnavn) throws Exception {
        Scanner fil = new Scanner(new File(filnavn));
        while (fil.hasNextLine() && totaltStudenter < navn.length) {
            navn[totaltStudenter] = fil.nextLine();
            totaltStudenter++;
        }
    }

    public void registrerOppmoete(String studentnavn) {
        for (int i = 0; i < totaltStudenter; i++) {
            if (studentnavn.equals(navn[i])){
                oppmoete[i] = true;
            }
        }
    }

    public void skrivUtAlleOppmoette() {
        for (int i = 0; i <totaltStudenter; i++) {
            if (oppmoete[i]) {
                System.out.println(navn[i] + " har møtt.");
            } else {
                System.out.println(navn[i] + " har IKKE møtt.");
            }
        }
    }
}
