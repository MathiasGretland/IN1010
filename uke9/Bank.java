package uke9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int pengeBelop;

    private Lock laas = new ReentrantLock();


    public int saldo(){
        return pengeBelop;
    }

    public void ta(int p){
        laas.lock();
        try {
            pengeBelop -= p;
        }finally {
            laas.unlock();
        }

    }

    public void gi(int p){
        laas.lock();
        try {
            pengeBelop += p;
        }finally {
            laas.unlock();
        }

    }
}
