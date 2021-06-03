package repetisjon;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pensum implements Runnable{
    Lock laas = new ReentrantLock();
    String melding;

    Pensum(String melding){
        this.melding = melding;
    }

    @Override
    public void run() {
        laas.lock();
        try {
            tekst();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }
    }

    public void tekst() throws InterruptedException {
        int i = 0;
        Date now = new Date();
        System.out.println(now + " " + melding + " " + (i+1));
        i++;
        Thread.sleep(1000);

    }

    public static void main(String[] args) {
        Pensum run =  new Pensum("Magnus");
        Pensum run2 =  new Pensum("Enholm");
        for (int i = 0; i < 10; i++){
            if (i % 2 == 0){
                Thread traad = new Thread(run);
                traad.run();
            }else if (i % 2 != 0){
                Thread traad2 = new Thread(run2);
                traad2.run();
            }
        }
    }
}
