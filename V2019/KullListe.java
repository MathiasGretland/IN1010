package V2019;

import java.util.Iterator;

public class KullListe extends Kull{
    Hund forste = null;

    KullListe(Hund mor, Hund far) {
        super(mor, far);
    }

    @Override
    public void settInn(Hund h) {
        if (forste == null){
            forste = h;
            return;
        }
        if (forste.compareTo(h) < 0){
            Hund gamleForste = forste;
            forste = h;
            forste.neste = gamleForste;
            return;
        }

        Hund iterHund = forste;
        while (iterHund.neste != null && h.compareTo(iterHund.neste) < 0){
            iterHund = iterHund.neste;
        }
        h.neste = iterHund.neste;
        iterHund.neste = h;
    }

    @Override
    public Iterator<Hund> iterator() {
        return new HundelisteIterator();
    }

    class HundelisteIterator implements Iterator<Hund>{
        private Hund denne = forste;

        @Override
        public boolean hasNext() {
            if (denne != null){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Hund next() {
            Hund returnHund = denne;
            denne = denne.neste;
            return returnHund;
        }
    }


}
