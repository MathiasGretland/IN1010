package uke9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NteTall {
    Condition provIgjen;
    Condition ikkeNeste;
    Lock talLaas;

    public NteTall(){
        talLaas = new ReentrantLock();
        ikkeNeste = talLaas.newCondition();
        provIgjen = talLaas.newCondition();
        NteMonitor m = new NteMonitor();

        for (int i = 0; i<10; i++){
            new Thread(new MinRun(i, 0, 1000, m)).start();
        }


    }

    public static void main(String[] args) {
        new NteTall();
    }

    class NteMonitor{
        int tall = -1;

        public void skrivUt(int i){
            talLaas.lock();
            try {
                while (i-1 != tall){
                    ikkeNeste.await();
                }

                tall = i;
                System.out.println(tall);
                ikkeNeste.signalAll();
            }
            catch (InterruptedException e){
                System.out.println("Feil!");
            }
            finally {
                talLaas.unlock();
            }
        }
    }
}
