package traader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tallmonitor {
    Lock laas = new ReentrantLock();
    int detMinste = Integer.MAX_VALUE;
    int detStorste = Integer.MAX_VALUE;


    public boolean settMinste(int tall){
        laas.lock();
        try {
            if (detStorste <= tall) {
                return false;
            }
            detMinste = tall;
            return true;
        } finally {
            laas.unlock();
        }
    }

    public boolean settStorste(int tall){
        laas.lock();
        try {
            if (tall <= detStorste){
                return false;
            }
            detStorste = tall;
            return true;
        } finally {
            laas.unlock();
        }
    }

    public static void main(String[] args) {
        Tallmonitor swag = new Tallmonitor();
        Thread nedover = new Thread(new Nedover(swag));
        nedover.start();

    }
}
