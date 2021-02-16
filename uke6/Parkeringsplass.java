package uke6;

public class Parkeringsplass <E>{
    private E kjoeretoey;

    public void parker(E kjoeretoey) {
        this.kjoeretoey = kjoeretoey;
    }

    public E hent(){


        E tmp = this.kjoeretoey;

        this.kjoeretoey = null;

        return tmp;
    }
}
