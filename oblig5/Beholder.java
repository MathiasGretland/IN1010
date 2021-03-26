package oblig5;

import java.util.ArrayList;
import java.util.HashMap;

public class Beholder {
    ArrayList<HashMap<String, Subsekvens>> liste = new ArrayList<>();
    int antall = 0;

    public static HashMap<String,Subsekvens> flette(HashMap<String,Subsekvens> Subsekvens1, HashMap<String,Subsekvens> Subsekvens2){
        Subsekvens hentaSub;
        HashMap<String, Subsekvens> nySubsekvens = new HashMap<>();
        for (Subsekvens sub : Subsekvens1.values()){
            hentaSub = Subsekvens2.remove(sub.hentSubsekvens());
            if (hentaSub == null){
                nySubsekvens.put(sub.hentSubsekvens(),sub);
            }else {
                int ant = hentaSub.hentAntall();
                sub.leggTilAntall(ant);
                nySubsekvens.put(sub.hentSubsekvens(),sub);
            }
        }

        for (Subsekvens sub2 : Subsekvens2.values()){
            nySubsekvens.put(sub2.hentSubsekvens(),sub2);
        }
        return nySubsekvens;
    }

    public void leggTil(HashMap<String, Subsekvens> nySubsekvens){
        liste.add(nySubsekvens);
        antall++;
    }

    public int antall(){
        return antall;
    }

    public HashMap<String, Subsekvens> taEn(){
        antall--;
        return liste.remove(0);
    }

    public void testHele () {
        System.out.println(" Utskrift av antallet i hver hashmap i beholderen; ");
        for  (HashMap<String, Subsekvens> hashMap: liste)
            System.out.println(" Storrelsen av HashMap:  " + hashMap.size() );
    }

}


