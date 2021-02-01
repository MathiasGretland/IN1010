package uke4;

import java.util.ArrayList;

public class Hovedprogram {
    public static void main(String[] args) {
        Dyr dyr = new Pattedyr();
        Dyr hilmar = new Menneske();
        Pattedyr pat = new Menneske();

        Hund hund = new Hund();
        Pattedyr sjef = new Hund();
        Dyr vovov = new Hund();

        dyr.spisMat();
        //hilmar.fantaserer();
        hilmar.spisMat();
        pat.produserMelk();

        if (hilmar instanceof Menneske){
            Menneske menneske = (Menneske) hilmar;
            menneske.fantaserer();
            menneske.spisMat();
        }else {
            hilmar.spisMat();
        }

        Slange slange = new Slange();
        Skilpadde padde = new Skilpadde();
        Krypdyr kryp = new Krypdyr();
        Dyr[] dyrehage = new Dyr[10];
        dyrehage[0] = dyr;
        dyrehage[1] = hilmar;
        dyrehage[2] = vovov;
        dyrehage[3] = pat;
        dyrehage[4] = slange;
        dyrehage[6] = padde;
        dyrehage[8] = kryp;

        for (int i = 0; i < dyrehage.length; i++){
            System.out.println(dyrehage[i]);
            if (dyrehage[i] !=null){
                System.out.println(dyrehage[i]);
                dyrehage[i].spisMat();
                if (dyrehage[i] instanceof Pattedyr){
                    Pattedyr pattedyr = (Pattedyr) dyrehage[i];
                    pattedyr.produserMelk();
                }
            }else {
                System.out.println("Her var det ikke noen dyr");
            }
        }
        ArrayList<Krypdyr> krypdyrpark = new ArrayList<Krypdyr>();
        krypdyrpark.add(new Krypdyr());
        for (int i = 0; i < dyrehage.length; i++){
            if (dyrehage[i] instanceof Krypdyr){
                //krypdyrpark.add((Krypdyr)dyrehage[i]);
                Krypdyr k = (Krypdyr)dyrehage[i];
                krypdyrpark.add(k);
            }
        }
        System.out.println(krypdyrpark);
        for (Krypdyr krypdyr : krypdyrpark){
            krypdyr.kryp();
        }
    }

}
