package uke10Repetisjon;

public class KlokkeKjorer implements Runnable{
    private volatile boolean fortsett = true;

    public void stopp(){
        fortsett = false;
    }

    @Override
    public void run() {
        int klokke = 0;
        try {
            while (fortsett){
                Thread.sleep(1000);
                System.out.println(klokke);
                klokke++;
            }
        } catch (InterruptedException e) {
            System.out.println("Klokka er ferdig.");
        }
    }
}
