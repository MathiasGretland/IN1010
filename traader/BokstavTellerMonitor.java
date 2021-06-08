package traader;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BokstavTellerMonitor {
    ArrayList<String> listeAvOrd;
    char bokstav;
    private Lock laas = new ReentrantLock();

    public BokstavTellerMonitor(ArrayList<String> listeAvOrd, char bokstav){
        this.listeAvOrd = listeAvOrd;
        this.bokstav = bokstav;
    }

    public String hentOrd(){
        laas.lock();
        try {
            if (listeAvOrd.isEmpty()){
                return null;
            }
            return listeAvOrd.remove(listeAvOrd.size()-1);
        }finally {
            laas.unlock();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();

        liste.add("kebabrull");
        liste.add("Majones");
        liste.add("Torketrommel");

        BokstavTellerMonitor swag = new BokstavTellerMonitor(liste, 'l');
        Thread traad = new Thread(new BokstavTeller(swag));
        traad.start();

    }
}
