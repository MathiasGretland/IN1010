package uke10Repetisjon;

public class Oppover implements Runnable{
    private TallMonitor tallMonitor;
    private int tall;

    public Oppover(TallMonitor tallMonitor){
        this.tallMonitor = tallMonitor;
        tall = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        while (tallMonitor.settMinste(tall)){
            tall++;
        }
        System.out.println("STOPP! Tallet er ikke lenger minst: " + tall);
    }
}
