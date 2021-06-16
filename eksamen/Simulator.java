package eksamen;

public class Simulator {
    PrioKo prioKo = new PrioKo();
    Aktivitet[] aktivitetsArray;
    int globaltid = 0;

    Simulator(Aktivitet[] aktivitetsArray){
        this.aktivitetsArray = aktivitetsArray;
        //Vi antar at iteratoren er implementert.
        for (Aktivitet a : aktivitetsArray){
            prioKo.settInn(a);
        }
    }

    public void simuler(int t){
        while (globaltid < t){
            Aktivitet lavest = prioKo.hentUt();
            lavest.handling();
            globaltid = lavest.tid;
            System.out.println(globaltid);
            prioKo.settInn(lavest);
        }
    }
}
