package uke10Repetisjon;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    int tall = 0;
    Lock laas = new ReentrantLock();

    public void ta(int nyttTall){
        laas.lock();
        try {
            tall -= nyttTall;
        }finally {
            laas.unlock();
        }
    }

    public void gi(int nyttTall){
        laas.lock();
        try {
            tall += nyttTall;
        }finally {
            laas.unlock();
        }
    }

    public int saldo(){
        return tall;
    }
}
