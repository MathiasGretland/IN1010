//Må fjernes for at den skal fungere
//Skriv for eksempel: java FinnAntall.java solar minfil.txt 8
package uke9;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ordmonitor {
    public int antall = 0;

    public Lock laas = new ReentrantLock();

    public void fantOrdet(){
        laas.lock();
        try {
            antall++;
        }finally {
            laas.unlock();
        }
    }

    public int hentAntall(){
        return antall;
    }
}
