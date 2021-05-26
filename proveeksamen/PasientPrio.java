package proveeksamen;

public class PasientPrio extends PasientAdm{
    Pasient start = null;
    Pasient [] maxPasienterStartArray = new Pasient[Pasient.MAXPASPRIO+1];
    Pasient [] maxPasienterSluttArray = new Pasient[Pasient.MAXPASPRIO+1];


    @Override
    public void settInnPasient(Pasient p) {
        if (start == null){
            start = p;
            maxPasienterSluttArray[start.prioritet] = start;
            maxPasienterStartArray[start.prioritet] = start;
        }
        else {
            p.neste = maxPasienterStartArray[p.prioritet];
            maxPasienterSluttArray[p.prioritet-1].neste = p;
        }
    }

    @Override
    public Pasient hentUt(Pasient p) {
        if (p == null){
            return null;
        }
        return maxPasienterStartArray[p.prioritet];
    }

    @Override
    public Pasient hentUt(int i) {
        return maxPasienterStartArray[i];
    }
}
