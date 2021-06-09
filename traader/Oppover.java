package traader;

public class Oppover implements Runnable{
    Tallmonitor monitor;
    int tall;

    Oppover(Tallmonitor monitor){
        this.monitor = monitor;
        tall = monitor.detMinste;
    }


    @Override
    public void run() {
        while (tall < monitor.detStorste){
            System.out.println(tall);
            tall++;
        }
    }
}
