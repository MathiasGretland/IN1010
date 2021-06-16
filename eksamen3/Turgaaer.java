package eksamen3;

import java.util.concurrent.CountDownLatch;

public class Turgaaer implements Runnable{
    int hastighet;
    Kryss sted;
    CountDownLatch ferdig;

    Turgaaer(int hastighet, Kryss sted, CountDownLatch ferdig){
        this.hastighet = hastighet;
        this.sted = sted;
        this.ferdig = ferdig;

    }

    @Override
    public void run() {
        while (true){
            try {
                sted.turgaaerKommer();
                Thread.sleep(Trekk.trekkInt(1,5) * 1000);
                sted.turgaaerGaar();
                Sti sti = sted.hentTilfeldigSti();
                Thread.sleep(sti.beregnGaaTid(hastighet));
                sted = sti.finnAndreEnde();
                ferdig.await();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
