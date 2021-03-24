package uke10.uke8oppgave;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapBeholder {
    ArrayList<HashMap<String, SubSekvens>> liste = new ArrayList<>();
    int antall = 0;

    public static HashMap<String,SubSekvens> flette(HashMap<String,SubSekvens> Subsekvens1, HashMap<String,SubSekvens> Subsekvens2){
        SubSekvens hentaSub;
        HashMap<String, SubSekvens> nySubsekvens = new HashMap<>();
        for (SubSekvens sub : Subsekvens1.values()){
            hentaSub = Subsekvens2.remove(sub.hentSubsekvens());
            if (hentaSub == null){
                nySubsekvens.put(sub.hentSubsekvens(),sub);
            }else {
                int ant = hentaSub.hentAntall();
                sub.leggTilAntall(ant);
                nySubsekvens.put(sub.hentSubsekvens(),sub);
            }
        }

        for (SubSekvens sub2 : Subsekvens2.values()){
            nySubsekvens.put(sub2.hentSubsekvens(),sub2);
        }
        return nySubsekvens;
    }

    public void leggTil(HashMap<String, SubSekvens> nySubsekvens){
        liste.add(nySubsekvens);
        antall++;
    }

    public int antall(){
        return antall;
    }

    public HashMap<String, SubSekvens> taEn(){
        antall--;
        return liste.remove(0);
    }

    public void testHele () {
        System.out.println(" Utskrift av antallet i hver hashmap i beholderen; ");
        for  (HashMap<String, SubSekvens> hashN: liste)
            System.out.println(" Storrelsen av HashMap:  " + hashN.size() );
    }

}
