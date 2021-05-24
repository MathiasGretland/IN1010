package repetisjon;

public class Kokelere implements Runnable{
    private FellesBord bord;
    private int antallSomSkalLages;

    public Kokelere(FellesBord f, int antall){
        bord = f;
        antallSomSkalLages = antall;
    }


    @Override
    public void run() {
        int antallLaget = 0;
        while (antallLaget < antallSomSkalLages){
            //Sett tallerken på bordet
            System.out.println("En kokk setter en tallerken");
            try {
                bord.settTallerken();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            antallLaget++;
        }
    }
}
