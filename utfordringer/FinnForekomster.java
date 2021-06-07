package utfordringer;

public class FinnForekomster implements Runnable{
    FinnAntall denne;
    String ord;

    FinnForekomster(FinnAntall denne, String ord){
        this.denne = denne;
        this.ord = ord;
    }


    @Override
    public void run() {
        try {
            denne.finnForekomster(ord);
            denne.swagStopper.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
