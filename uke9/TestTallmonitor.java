package uke9;

public class TestTallmonitor {
    public static void main(String[] args) {
        Tallmonitor m = new Tallmonitor();
        Thread traad1 = new Thread(new Nedover(m));
        Thread traad2 = new Thread(new Oppover(m));
        traad1.start();
        traad2.start();
    }
}
