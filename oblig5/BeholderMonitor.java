package oblig5;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BeholderMonitor {
    final Lock laas;
    final Condition ikkeTomBeholder;
    final Condition ventForFletting;
    Beholder beholder;

    public BeholderMonitor(Beholder beholder){
        this.beholder = beholder;
        laas = new ReentrantLock();
        ikkeTomBeholder = laas.newCondition();
        ventForFletting = laas.newCondition();
    }

    public void laasForLeggTil(HashMap<String, Subsekvens> nySubsekvens){
        laas.lock();
        try {
            beholder.leggTil(nySubsekvens);
        } finally {
            laas.unlock();
        }
    }

    public void laasForTaEn(){
        laas.lock();
        try {
            while (beholder.antall() != 0){
                beholder.taEn();
            }
        }finally {
            laas.unlock();
        }
    }

    public void laasForFlette(HashMap<String,Subsekvens> Subsekvens1, HashMap<String,Subsekvens> Subsekvens2){
        laas.lock();
        try {
            while (beholder.antall() != 0){
                beholder.flette(Subsekvens1, Subsekvens2);
            }
        }finally {
            laas.unlock();
        }
    }
}
