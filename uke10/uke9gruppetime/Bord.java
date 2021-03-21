package uke10.uke9gruppetime;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bord {
    private ArrayList<String> bord = new ArrayList<>();
    private Lock bordLaas = new ReentrantLock();
    private Condition ingenKaffe = bordLaas.newCondition();
    private int antallFerdige = 0;
    private int antallBarista;

    public Bord(int antallBarista){
        this.antallBarista = antallBarista;
    }

    public void server(String kaffe){
        bordLaas.lock();
        if(kaffe.equals("tomt")){
            antallFerdige++;
        }else{
            bord.add(kaffe);
        }
        ingenKaffe.signalAll();
        bordLaas.unlock();
    }

    public String hentKaffe(){
        bordLaas.lock();
        try{
            while(bord.isEmpty()){
                if(antallBarista == antallFerdige){
                    ingenKaffe.signalAll();
                    return "tomt";
                }
                ingenKaffe.await();
            }
            return bord.remove(0);
        } catch (InterruptedException e){
            System.out.println("Ble forstyrret naar kaffe skulle hentes");
        } finally {
            bordLaas.unlock();
        }
        return "tomt";
    }
}
