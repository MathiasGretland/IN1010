package uke10Repetisjon;

public class TestTallMonitor {
    public static void main(String[] args) {
        TallMonitor tallMonitor = new TallMonitor();
        Thread traad1 = new Thread(new Oppover(tallMonitor));
        Thread traad2 = new Thread(new Nedover(tallMonitor));
        traad1.start();
        traad2.start();
    }
}
