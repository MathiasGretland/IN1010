package repetisjon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FellesBord {
    private Lock laas = new ReentrantLock();
    private Condition ledigPlass = laas.newCondition();
    private Condition ikkeTomtBord = laas.newCondition();
    private int antallKlare = 0;
    private int MAKS_ANTALL = 10;

    public void settTallerken() throws InterruptedException {
        laas.lock();
        try {
            while (antallKlare == MAKS_ANTALL){
                ledigPlass.await();
            }
            int tall = antallKlare +1;
            System.out.println("Vi la til en tallerken, det er nå " + tall);
            antallKlare = tall;
            ikkeTomtBord.signalAll();
        } finally {
            laas.unlock();
        }
    }

    public void hentTallerken() throws InterruptedException {
        laas.lock();
        try {
            while (antallKlare == 0){
                ikkeTomtBord.await();
            }
            int tall = antallKlare -1;
            System.out.println("Vi hentet en tallerken, det er nå " + tall);
            antallKlare = tall;
            ledigPlass.signalAll();
        } finally {
            laas.unlock();
        }
    }
}
