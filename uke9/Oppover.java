package uke9;

public class Oppover implements Runnable{
    private Tallmonitor tallmonitor;
    private int tall;

    public Oppover(Tallmonitor monitor){
        tallmonitor = monitor;
        tall = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        while (tallmonitor.settMinste(tall)){
            tall++;
        }
        System.out.println("STOPP! Tallet er ikke lenger minst " + tall);
    }
}
