package uke10Repetisjon;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TallMonitor {
    private int detMinste = Integer.MIN_VALUE;
    private int detStorste = Integer.MAX_VALUE;
    Lock laas = new ReentrantLock();

    public boolean settMinste(int tall){
        laas.lock();
        try {
            if (detStorste <= tall) return false;
            detMinste = tall;
            return true;
        }finally {
            laas.unlock();
        }
    }

    public boolean settStorste(int tall){
        laas.lock();
        try {
            if (tall <= detMinste) return false;
            detStorste = tall;
            return true;
        }finally {
            laas.unlock();
        }
    }
}
