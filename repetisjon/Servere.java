package repetisjon;

public class Servere implements Runnable{
    private FellesBord bord;
    private int antallSomSkalServeres;

    public Servere(FellesBord bord, int antallSomSkalServeres){
        this.bord = bord;
        this.antallSomSkalServeres = antallSomSkalServeres;
    }

    @Override
    public void run() {
        int antallServert = 0;
        while (antallServert < antallSomSkalServeres){
            try {
                bord.hentTallerken();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hentet en tallerken.");
            antallServert++;
        }
    }
}
