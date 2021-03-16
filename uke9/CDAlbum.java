package uke9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CDAlbum implements Comparable<CDAlbum>{
    String artistnavn;
    String albumnavn;
    int utgivelsesaar;
    public CDAlbum(String artistnavn, String albumnavn, int utgivelsesaar){
        this.artistnavn = artistnavn;
        this.albumnavn = albumnavn;
        this.utgivelsesaar = utgivelsesaar;
    }

    public static void main(String[] args) {
        ArrayList<CDAlbum> cdsamling = lesOgSorter("uke9/innFil.txt");

        for (CDAlbum a : cdsamling) {
            System.out.println(a);
        }

    }

    public String hentArtistnavn(){
        return this.artistnavn;
    }

    //Leser inn og sorterer
    public static ArrayList<CDAlbum> lesOgSorter(String filnavn) {
        File f = new File(filnavn);
        Scanner inf;
        try {
            inf = new Scanner(f);
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen!");
            return null;
        }

        ArrayList<CDAlbum> liste = new ArrayList<CDAlbum>();

        while (inf.hasNextLine()) {
            String[] linje = inf.nextLine().split(",");
            String artist = linje[0];
            String album = linje[1];
            int aar = Integer.parseInt(linje[2]);

            CDAlbum nyttAlbum = new CDAlbum(artist, album, aar);

            boolean sattInn = false;
            int teller = 0;

            while (teller < liste.size() && !sattInn){
                if (nyttAlbum.compareTo(liste.get(teller)) < 0){
                    liste.add(teller, nyttAlbum);
                    sattInn = true;
                }
                teller++;
            }

            if (!sattInn){
                liste.add(nyttAlbum);
            }
        }
        return liste;
    }

    @Override
    public int compareTo(CDAlbum p) {
        return albumnavn.compareTo(p.hentArtistnavn());
    }

    public String toString(){
        String streng = "Artistnavn: " + artistnavn + "\n";
        streng += "Albumavn: " + albumnavn + "\n";
        streng += "Utgivelsesaar: " + utgivelsesaar + "\n";
        return streng;
    }
}
