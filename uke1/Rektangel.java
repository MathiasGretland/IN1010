package uke1;

class Rektangel {

    double bredde;
    double lengde;

    public Rektangel(double l, double b) { // Konstruktør
        lengde = l;
        bredde = b;
    }

    public void oekLengde(int okning) { // Oek lengden som angitt
        lengde += okning;
    }

    public void oekBredde(int okning) { // Oek bredden som angitt
        bredde += okning;
    }

    public double areal() { // Beregn mitt areal
        return bredde * lengde;
    }

    public double omkrets() { // Beregn min omkrets
        return bredde * 2 + lengde * 2;
    }

    public void reduserBredde(int reduser) {
        if (bredde - reduser < 1) {
            System.out.println("Bredden kan ikke reduseres så mye");
        } else {
            bredde = bredde - reduser;
        }
    }

    public void reduserLengde(int reduser) {
        if (lengde - reduser < 1) {
            System.out.println("Lengden kan ikke redsueres så mye");
        } else {
            lengde -= reduser;
        }
    }
}