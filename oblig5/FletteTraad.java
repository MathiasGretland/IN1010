package oblig5;

import java.util.concurrent.CountDownLatch;

/**
 * Klassen FletteTraad er en run metode som fletter sammen to hashmaps.
 */
public class FletteTraad implements Runnable{
    CountDownLatch barriere;
    Beholder beholder;
    BeholderMonitor beholderMonitor;

    /**
     * Konstruktøren
     * @param beholder Tar inn beholderen
     * @param beholderMonitor Tar inn beholderen sin monitor klasse
     * @param barriere Tar inn en CountDownLatch
     */
    public FletteTraad(Beholder beholder, BeholderMonitor beholderMonitor, CountDownLatch barriere){
        this.barriere = barriere;
        this.beholder = beholder;
        this.beholderMonitor = beholderMonitor;
    }

    /**
     * Run metoden som fletter, Sover i 1 sekund mellom hver traad.
     */
    @Override
    public void run() {
        beholderMonitor.laasForLeggTil(Beholder.flette(beholderMonitor.laasForTaEn(), beholderMonitor.laasForTaEn()));
        try {
            Thread.sleep(10);
            barriere.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
