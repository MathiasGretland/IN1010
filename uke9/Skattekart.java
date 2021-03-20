package uke9;

import uke3.Figur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skattekart {
    private char[][] skattekart;
    private int hoyde;
    private int bredde;
    private boolean skattFunnet = false;

    private Skattekart(char[][] kart, int hoyde, int bredde){
        skattekart = kart;
        this.hoyde = hoyde;
        this.bredde = bredde;
    }

    static Skattekart lesInn(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        String[] str = sc.nextLine().split(" ");
        int antR = Integer.parseInt(str[0]);
        int antK = Integer.parseInt(str[1]);

        char[][] kart = new char[antR][antK];

        for (int rad = 0; rad < antR; rad++){
            String linje = sc.nextLine();

            for (int kol = 0; kol < antK; kol++){
                kart[rad][kol] = linje.charAt(kol);
            }
        }

        Skattekart sk = new Skattekart(kart, antR, antK);

        return sk;
    }

    public void skrivUt(){
        for (int i = 0; i < skattekart.length; i++){
            for (int j = 0; j < skattekart[i].length; j++){
                if (skattFunnet){
                    System.out.print(skattekart[i][j]);
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    public boolean sjekk(int kol, int rad){
        if (skattekart[kol][rad] == 'X'){
            skattFunnet = true;
        }
        return skattFunnet;
    }
}
