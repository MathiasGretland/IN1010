package utfordringer;

import java.util.Scanner;

public class SkattIRuritania {

    public static double regnUtSkatt(double n){
        if (n < 10000){
            return (n * 0.1);
        }
        else if (n >= 10000){
            double etterForsteTiTusen = n - 10000;
            double skattForsteTiTusen = (n * 0.1);
            double restenAvSkatten = (etterForsteTiTusen * 0.3);
            return skattForsteTiTusen + restenAvSkatten;
        }else {
            System.out.println("Ugyldig tall oppgitt");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        double tall = tastatur.nextDouble();
        double skatt = regnUtSkatt(tall);
        System.out.println("Kroner som skal betales: " + skatt);
    }
}
