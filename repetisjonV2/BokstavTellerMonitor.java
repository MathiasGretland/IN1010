package repetisjonV2;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BokstavTellerMonitor {
    ArrayList<String> listeMedOrd;
    char bokstav;
    Lock laas = new ReentrantLock();

    BokstavTellerMonitor(ArrayList<String> listeMedOrd, char bokstav){
        this.listeMedOrd = listeMedOrd;
        this.bokstav = bokstav;

    }

    public String hentOrd(){
        laas.lock();
        try {
            return listeMedOrd.remove(listeMedOrd.size()-1);
        }finally {
            laas.unlock();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> listeMedOrd = new ArrayList<>();
        listeMedOrd.add("KEBAB");
        listeMedOrd.add("APEKATT");
        listeMedOrd.add("SWAG");

        BokstavTellerMonitor monitor = new BokstavTellerMonitor(listeMedOrd, 'a');
        BokstavTeller kekw = new BokstavTeller(monitor);
        Thread traad = new Thread(kekw);
        traad.start();
    }
}
