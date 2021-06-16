package eksamen4;

public class Turgaaer extends Aktivitet{
    int hastighet;
    Kryss sted;

    Turgaaer(int hastighet, Kryss sted){
        this.hastighet = hastighet;
        this.sted = sted;
        tid = 0;
    }


    @Override
    public void handling() {
        Sti stien = sted.hentTilfeldigSti();
        Kryss andreEnde = stien.finnAndreEnde();
        int gaaTid = stien.beregnGaaTid(hastighet);
        tid += gaaTid;
        sted = andreEnde;
    }
}
