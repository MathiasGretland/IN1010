package oblig5;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Klassen BeholderMonitor fungerer som en monitor klasse over Beholder klassen
 */
public class BeholderMonitor {
    final Lock laas;
    final Condition ikkeTomBeholder;
    final Condition ventForFletting;
    Beholder beholder;

    /**
     * Konstruktør
     * @param beholder tar inn et beholder objekt
     */
    public BeholderMonitor(Beholder beholder){
        this.beholder = beholder;
        laas = new ReentrantLock();
        ikkeTomBeholder = laas.newCondition();
        ventForFletting = laas.newCondition();
    }

    /**
     * Fungerer som en lås for metoden leggTil
     * @param nySubsekvens  Tar inn en ny Subsekvens
     */
    public void laasForLeggTil(HashMap<String, Subsekvens> nySubsekvens){
        laas.lock();
        try {
            beholder.leggTil(nySubsekvens);
        } finally {
            laas.unlock();
        }
    }

    /**
     * Fungerer som en lås for metoden taEn
     * @return objekt med plassering 0 i beholderen
     */
    public HashMap<String,Subsekvens> laasForTaEn(){
        laas.lock();
        try {
            while (beholder.antall() != 0) {
                return beholder.taEn();
            }
        }finally {
            laas.unlock();
        }
        return null;
    }
}
