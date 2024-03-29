package uke9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tallmonitor {
    private int detMinste = Integer.MIN_VALUE;
    private int detStorste = Integer.MAX_VALUE;
    private Lock laas = new ReentrantLock();

    public boolean settMinste(int nyMinste){
        laas.lock();
        try {
            if (detMinste <= nyMinste) return false;
            detMinste = nyMinste;
            return true;
        }finally {
            laas.unlock();
        }

    }

    public boolean settStorste(int nyStorste){
        laas.lock();
        try {
            if (detStorste >= nyStorste) return false;
            detStorste = nyStorste;
            return true;
        }finally {
            laas.unlock();
        }
    }
}
