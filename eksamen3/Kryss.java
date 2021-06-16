package eksamen3;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kryss {
    ArrayList<Sti> listeMedStier = new ArrayList<>();
    Lock laas = new ReentrantLock();
    Condition ingenLedigeSitteplasser = laas.newCondition();
    static final int ANTALL_SETER = 4;
    int ledigeSitteplasser = ANTALL_SETER;



    public void leggTilSti(Sti sti){
        listeMedStier.add(sti);
    }

    public Sti hentTilfeldigSti(){
        if (listeMedStier.isEmpty()){
            return null;
        } else {
            return listeMedStier.get(Trekk.trekkInt(0, listeMedStier.size()-1));
        }
    }

    public boolean erIsolert(){
        if (listeMedStier.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void turgaaerKommer(){
        laas.lock();
        try{
            while (ledigeSitteplasser <= 0){
                ingenLedigeSitteplasser.await();
            }
            ledigeSitteplasser -= 1;
        } catch (InterruptedException e) {
            System.out.println("Turgaaeren er ferdig");
        } finally {
            laas.unlock();
        }
    }

    public void turgaaerGaar(){
        laas.lock();
        try {
            ledigeSitteplasser += 1;
            ingenLedigeSitteplasser.signalAll();
        }finally {
            laas.unlock();
        }
    }

}
