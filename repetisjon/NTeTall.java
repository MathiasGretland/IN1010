package repetisjon;

import java.util.Scanner;

public class NTeTall implements Runnable{
    @Override
    public void run() {
        int klokke = 0;
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println(klokke);
                klokke ++;
            }
        }
        catch (InterruptedException i) {
            System.out.println("Klokka er ferdig");
        }
    }

    public static void main(String[] args) {
        Scanner minInn = new Scanner(System.in);
        Runnable minRun = new NTeTall();
        Thread traad = new Thread(minRun);
        System.out.println("Tast ENTER for å stoppe og starte");
        minInn.nextLine();
        traad.start();
        minInn.nextLine();
        traad.interrupt();
        System.out.println("Takk for nå!");
    }
}
