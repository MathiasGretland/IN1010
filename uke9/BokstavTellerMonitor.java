package uke9;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BokstavTellerMonitor {
    private ArrayList<String> ordListe;
    private Lock laas = new ReentrantLock();
    private char bokstav;

    public BokstavTellerMonitor(ArrayList<String> ordListe, Lock laas, char bokstav){
        this.ordListe = ordListe;
        this.laas = laas;
        this.bokstav = bokstav;
    }

    public char bokstaven(){
        return bokstav;
    }

    private String hentOrd(){
        laas.lock();
        try {
            if (ordListe.isEmpty()){
                return null;
            }
            return ordListe.remove(ordListe.size()-1);
        }finally {
            laas.unlock();
        }

    }
}
