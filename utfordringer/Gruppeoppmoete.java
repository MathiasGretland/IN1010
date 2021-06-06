package utfordringer;

import java.io.File;
import java.util.Scanner;

public class Gruppeoppmoete {
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];
    private int antallStudenter = navn.length;

    Gruppeoppmoete(){
        lesInnFil();
    }

    public void lesInnFil(){
        Scanner fil = null;
        String filnavn = "utfordringer/gruppeliste.txt";
        try {
            fil = new Scanner(new File(filnavn));
        } catch (Exception e){
            System.out.println("Kan ikke lese " + filnavn + "!");
            System.exit(1);
        }
        int teller = 0;
        while (fil.hasNextLine() && teller < 14){
            String linje = fil.nextLine();
            navn[teller] = linje;
            teller++;
        }
    }

    public void registrerOppmote(String n){
        for (int i = 0; i < navn.length; i++){
            if (navn[i].equals(n)){
                oppmoete[i] = true;
            }
        }
    }

    public void skrivUtAlle(){
        for (int i = 0; i < antallStudenter; i++){
            if (oppmoete[i] == true) {
                System.out.println(navn[i] + " har møtt opp");
            }else {
                System.out.println(navn[i] + " har ikke møtt opp");
            }
        }
    }
}
