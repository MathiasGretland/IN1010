package traader;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Avstemning implements Runnable{
    public int tellerPannekaker = 0;
    public int tellerGrot = 0;
    public CountDownLatch ferdig;
    Lock laas = new ReentrantLock();

    public Avstemning(CountDownLatch ferdig){
        this.ferdig = ferdig;
    }

    @Override
    public void run() {
        try {
            avstemning();
            ferdig.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void avstemning(){
        laas.lock();
        try {
            Random random = new Random();
            if (random.nextBoolean()){
                tellerPannekaker++;
            }else {
                tellerGrot++;
            }
        }finally {
            laas.unlock();
        }

    }

    public void skrivResultat(){
        System.out.println("Stemmer for Pannekaker: " + tellerPannekaker);
        System.out.println("Stemmer for Grøt: " + tellerGrot);
    }

    public static void main(String[] args){
        CountDownLatch ferdig = new CountDownLatch(435);
        Avstemning avstemning = new Avstemning(ferdig);
        for (int i = 0; i < 435; i++){
            Thread traad = new Thread(avstemning);
            traad.start();
            ferdig.countDown();
        }
        avstemning.skrivResultat();
    }
}
