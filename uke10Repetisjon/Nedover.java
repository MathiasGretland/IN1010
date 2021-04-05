package uke10Repetisjon;

public class Nedover implements Runnable{
    private TallMonitor tallMonitor;
    private int tall;

    public Nedover(TallMonitor tallMonitor){
        this.tallMonitor = tallMonitor;
        tall = Integer.MAX_VALUE;
    }

    @Override
    public void run() {
        while (tallMonitor.settStorste(tall)){
            tall--;
        }
        System.out.println("STOPP! Tallet er ikke lenger størst: " + tall);
    }
}
