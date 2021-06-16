package eksamen3;

import java.util.concurrent.CountDownLatch;

public class TestSimulator {
    public static void main(String[] args) throws InterruptedException {
        //Vi antar at vi oppretter 10 stier og 10 kryss
        Skog skogen = new Skog(10, 10);
        final int MAXTURGAAERE = 5;
        CountDownLatch ferdig = new CountDownLatch(MAXTURGAAERE);
        Thread[] traadene = new Thread[MAXTURGAAERE];
        for (int i = 0; i < MAXTURGAAERE; i++){
            Turgaaer turgaaer= new Turgaaer(Trekk.trekkInt(20 ,200) , skogen.hentTilfeldigStart(), ferdig);
            Thread traad = new Thread(turgaaer);
            traad.start();
            traadene[i] = traad;
            ferdig.countDown();
        }
        //Hvis traadene holder på i 2 timer, så slutter programmet
        Thread.sleep((60 * 1000)*120);
        for (Thread t : traadene){
            t.interrupt();
        }


    }
}
