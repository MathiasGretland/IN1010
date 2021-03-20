package uke9;

public class Nedover implements Runnable{
    private Tallmonitor tallmonitor;
    private int tall;

    public Nedover(Tallmonitor monitor){
        tallmonitor = monitor;
        tall = Integer.MAX_VALUE;
    }

    @Override
    public void run() {
        while (tallmonitor.settStorste(tall)){
            tall--;
        }
        System.out.println("STOPP! Tallet er ikke lenger størst " + tall);

    }
}
