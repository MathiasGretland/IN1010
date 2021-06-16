package eksamen;

public class TestSimulator {
    public static void main(String[] args) {
        //Vi antar at vi oppretter 10 stier og 10 kryss
        Skog skogen = new Skog(10, 10);
        final int MAXTURGAAERE = 5;
        Turgaaer[] turgaaere = new Turgaaer[MAXTURGAAERE];
        for (int i = 0; i < MAXTURGAAERE; i++){
            turgaaere[i] = new Turgaaer(Trekk.trekkInt(20 ,200) , skogen.hentTilfeldigStart());
        }
        Simulator simulator = new Simulator(turgaaere);
        simulator.simuler(Trekk.trekkInt(30, 480));
    }
}
