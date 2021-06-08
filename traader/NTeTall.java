package traader;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NTeTall implements Runnable{
    int start;
    int maks;

    Condition ikkeNeste;
    Condition provIgjen;
    Lock tallLaas;

    public NTeTall(int start, int maks){
        this.start = start;
        this.maks = maks;

        tallLaas = new ReentrantLock();
        ikkeNeste = tallLaas.newCondition();
        provIgjen = tallLaas.newCondition();


    }

    @Override
    public void run() {
        try {
            while (start <= maks) {
                Thread.sleep(100);
                System.out.println(start);
                start++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable minRun = new NTeTall(20, 100);
        for (int i = 0; i <= 10; i++){
            Thread traad = new Thread(minRun);
            traad.start();
        }


    }
}
