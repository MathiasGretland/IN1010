package traader;

public class Nedover implements Runnable{
    Tallmonitor monitor;
    int tall;
    public Nedover(Tallmonitor monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        tall = monitor.detMinste;
        while (monitor.detStorste > 0){
            System.out.println(tall);
            tall--;
            monitor.settStorste(tall);
        }
        System.out.println("Tallet er ikke lenger storst!");
    }
}
