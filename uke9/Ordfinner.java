//Må fjernes for at den skal fungere
//Skriv for eksempel: java FinnAntall.java solar minfil.txt 8
package uke9;

import java.util.concurrent.CountDownLatch;

public class Ordfinner implements Runnable{
    String [] listeMedOrd;
    String ordSomSkalFinnes;
    Ordmonitor ordmonitor;
    CountDownLatch count;
    int startIndeks;
    int sluttIndeks;

    public Ordfinner(String[] listeMedOrd, String ordSomSkalFinnes, Ordmonitor ordmonitor,CountDownLatch count, int startIndeks, int sluttIndeks){
        this.listeMedOrd = listeMedOrd;
        this.ordSomSkalFinnes = ordSomSkalFinnes;
        this.ordmonitor = ordmonitor;
        this.count = count;
        this.startIndeks = startIndeks;
        this.sluttIndeks = sluttIndeks;
    }

    @Override
    public void run() {
        for (int i = startIndeks; i < sluttIndeks; i++){
            if (listeMedOrd[i].equals(ordSomSkalFinnes)){
                ordmonitor.fantOrdet();
            }
        }
        count.countDown();
    }
}
