package repetisjon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CDSamling {
    ArrayList<CDAlbum> liste = new ArrayList<>();


    public void lesFraFil(String filnavn){
        File fil = new File(filnavn);
        Scanner inf;
        try {
            inf = new Scanner(fil);
        } catch (FileNotFoundException exception) {
            System.out.println("Fant ikke filen");
            inf = new Scanner("");
        }

        while (inf.hasNextLine()){
            String linje = inf.nextLine();
            String[] data = linje.split(",");
            String artistnavn = data[0];
            String albumnavn = data[1];
            String aar = data[2];
            int utgivelsesaar = Integer.parseInt(aar);
            CDAlbum album = new CDAlbum(artistnavn,albumnavn,utgivelsesaar);
            liste.add(album);
        }
    }

    public void sortertListe(){
        Collections.sort(liste);
    }



    public static void main(String[] args) {
        CDSamling samling = new CDSamling();
        samling.lesFraFil("repetisjon/cdliste.txt");
        for (CDAlbum a : samling.liste){
            System.out.println(a);
        }
        System.out.println();
        System.out.println();
        System.out.println();

        samling.sortertListe();
        for (CDAlbum a : samling.liste){
            System.out.println(a);
        }
    }
}
