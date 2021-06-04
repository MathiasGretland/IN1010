package V2019;

import java.util.Iterator;

public class KullArray extends Kull{
    Hund [] hundene = new Hund[60];

    KullArray(Hund mor, Hund far) {
        super(mor, far);
    }

    @Override
    public void settInn(Hund h) {
        int sekFodt = h.minFodselstid.sek;
        h.neste = hundene[sekFodt];
        hundene[sekFodt] = h;
    }

    public void skrivUtAlle(){
        /*
        //Antar at Iteratoren er implementert.
        for (Hund h : hundene){
            System.out.println("Navn: " + h.navn);
        }
         */
        for (int i = 0; i < 60; i++){
            Hund h = hundene[i];
            while (h != null){
                System.out.println(h.navn);
                h = h.neste;
            }
        }
    }

    @Override
    public Iterator<Hund> iterator() {
        return null;
    }
}
