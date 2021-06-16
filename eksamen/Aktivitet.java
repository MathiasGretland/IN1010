package eksamen;

public abstract class Aktivitet implements Comparable<Aktivitet>{
    Aktivitet neste;
    Aktivitet forrige;
    int tid;

    public abstract void handling();

    @Override
    public int compareTo(Aktivitet a){
        return tid - a.tid;
    }
}
