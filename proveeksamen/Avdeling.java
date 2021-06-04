package proveeksamen;

public class Avdeling {
    PasientAdm pasienter;

    public void settInn(Pasient p){
        pasienter.settInnPasient(p);
    }

    public Pasient hentUt(Pasient p){
        return pasienter.hentUt(p);
    }

    public Pasient hentUt(int i){
        return pasienter.hentUt(i);
    }
}
