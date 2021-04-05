package uke10.uke8oppgave;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Hovedprogram {
    static int subLengde = 3;
    static String metadataFilbane = "uke10/uke8oppgave/metadata.txt";//Fyll inn!
    public static void main (String [ ] args) throws IOException {
        String linje;
        // char type;
        HashMapBeholder bufSyk = new HashMapBeholder();
        // int antallFiler = 0;
        try{
            Scanner leser = new Scanner(new File(metadataFilbane));
            System.out.println(" Velkommen til HashBeholder test hovedprogram ");

            while(leser.hasNextLine()) {
                linje = leser.nextLine();
                linje = linje.trim();
                lesFil(linje, bufSyk);

            }
            leser.close();
        } catch (IOException e) {System.out.println(e.getMessage()); }
        System.out.println( );
        bufSyk.testHele();

        while (bufSyk.antall() > 1) {
            HashMap<String, SubSekvens> res =
                    HashMapBeholder.flette(bufSyk.taEn(), bufSyk.taEn());
            bufSyk.leggTil(res);
        }


        System.out.println(" FERDIG med å samle data ");

        HashMap<String,SubSekvens> hSyk = bufSyk.taEn();
        System.out.println( );
        System.out.println(" Indikatorer på syke pasienter  " );
        for  (SubSekvens sS: hSyk.values()) {
            if(sS.hentAntall() > 7)
                System.out.println( sS.hentSubsekvens()+ "  med antall:   " + sS.hentAntall());
        }
        System.out.println(" FERDIG. Programmet terminerer. ");
    }

    static  void  lesFil(String filnavn, HashMapBeholder alleHashMaps) {
        String linje;
        String subStreng;
        try {
            Scanner leser = new Scanner(new File("uke10/uke8oppgave/"+ filnavn));

            HashMap<String,SubSekvens>  subSeqHash = new HashMap <> ();
            System.out.println(" Virussjekker leser fil   " + filnavn );


            while(leser.hasNextLine()) {
                linje = leser.nextLine();
                linje = linje.trim();
                for (int i = 0; i + subLengde <= linje.length(); i++) {
                    subStreng = linje.substring(i,i+subLengde);
                    subSeqHash.putIfAbsent(subStreng,new SubSekvens(subStreng));
                }
            }
            leser.close();
            alleHashMaps.leggTil(subSeqHash);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }


}
