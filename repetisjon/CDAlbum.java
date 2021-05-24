package repetisjon;

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

    public String hentArtistnavn(){
        return artistnavn;
    }


    @Override
    public String toString(){
        String strenge = "Artistnavn: " + artistnavn + " Albumnavn: " + albumnavn + " Utgivelsesaar: " + utgivelsesaar;
        return strenge;
    }

    @Override
    public int compareTo(CDAlbum nyAlbum) {
        int artistLengde = artistnavn.length();
        int nyArtistLengde = nyAlbum.artistnavn.length();
        return artistLengde - nyArtistLengde;
    }
}

