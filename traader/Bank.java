package traader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    Lock laas = new ReentrantLock();
    int pengeBelop;

    public Bank(int pengeBelop){
        this.pengeBelop = pengeBelop;
    }

    public void ta(int belop){
        laas.lock();
        try {
            pengeBelop -= belop;
        }finally {
            laas.unlock();
        }
    }

    public void gi(int belop){
        laas.lock();
        try {
            pengeBelop += belop;
        }finally {
            laas.unlock();
        }
    }

    public int saldo(){
        return pengeBelop;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(2000);
        int max = 2000;
        int min = 1;
        for (int i = 0; i < 100; i++){
            int t = (int)Math.floor(Math.random()*(max - min+1)+min);
            Thread traad = new Thread(new Penger(bank, t));
            traad.start();
        }

    }

}
