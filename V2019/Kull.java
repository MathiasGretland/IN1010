package V2019;

import java.util.Iterator;

abstract class Kull implements Iterable<Hund> {
    Hund mor;
    Hund far;

    Kull (Hund mor, Hund far) {
        this.mor = mor;
        this.far = far;
    }

    public abstract void settInn(Hund h);
    public abstract Iterator<Hund> iterator();
}