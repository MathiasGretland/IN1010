package uke10.uke9gruppetime;

class Hovedprogram{
    public static void main(String[] args) {
        int antallBarista = 2;
        int antallKaffeDrikkere = 10;

        Bord bord = new Bord(antallBarista);

        for(int i = 0; i < antallBarista; i++){
            new Thread(new Barista(bord, i)).start();
        }

        for(int i = 0; i < antallKaffeDrikkere; i++){
            new Thread(new Kaffedrikkere(bord, i)).start();
        }
    }
}
