package oblig5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Oppretter klassen Beholder
 */
public class Beholder {
    ArrayList<HashMap<String, Subsekvens>> liste = new ArrayList<>();
    int antall = 0;

    /**
     * Metoden flette utføres ved å legge sammen antall forekomster av like subsekvenser. Dersom en subsekvens går igjen i de to hashmapene som prosseseres,
     * skal den resulterende hashmapen ha denne subsekvensen som en av sine nøkler
     * @param Subsekvens1   Tar inn et subsekvens objekt
     * @param Subsekvens2   Tar inn et subsekvens objekt
     * @return returnerer en ny subsekvens som er slått sammen av to subsekvenser
     */
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

    /**
     *  Metoden leggTil legger til et subsekvens objekt til i beholderen
     * @param nySubsekvens Tar inn et subsekvens objekt
     */
    public void leggTil(HashMap<String, Subsekvens> nySubsekvens){
        liste.add(nySubsekvens);
        antall++;
    }

    /**
     * Metoden antall teller størrelsen til et hashmap
     * @return antall
     */
    public int antall(){
        return antall;
    }

    /**
     * Metoden taEn tar det første objektet i beholderen og fjerner den
     * @return det første objektet i beholderen
     */
    public HashMap<String, Subsekvens> taEn(){
        antall--;
        return liste.remove(0);
    }

    /**
     * Skriver ut en pen tekst om størrelsen til hashmap.
     */
    public void testHele () {
        System.out.println(" Utskrift av antallet i hver hashmap i beholderen; ");
        for  (HashMap<String, Subsekvens> hashMap: liste)
            System.out.println(" Storrelsen av HashMap:  " + hashMap.size() );
    }

}


