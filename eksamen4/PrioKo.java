package eksamen4;

public class PrioKo {

    Aktivitet start = null;
    Aktivitet slutt = null;

    public void settInn(Aktivitet a){
        if (start == null){
            start = a;
            slutt = a;
            return;
        }

        if (a.compareTo(slutt) > 0){
            Aktivitet gamelSlutt = slutt;
            slutt = a;
            slutt.forrige = gamelSlutt;
            gamelSlutt.neste = slutt;
            return;
        }
        Aktivitet iter = slutt;
        while (true){
            if (iter.forrige == null){
                Aktivitet gamlestart = start;
                gamlestart.forrige = a;
                start = a;
                start.neste = gamlestart;
                break;
            } else if(a.compareTo(iter.forrige) > 0){
                a.neste = iter.neste;
                iter.neste.forrige = a;
                iter.neste = a;
                a.forrige = iter;
                break;
            }else {
                iter = iter.forrige;
            }
        }


    }

    public Aktivitet hentUt(){
        if (start == null){
            return null;
        }else {
            Aktivitet tmp = start;
            start = start.neste;
            return tmp;
        }
    }
}
