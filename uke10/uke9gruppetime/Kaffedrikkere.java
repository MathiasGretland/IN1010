package uke10.uke9gruppetime;

public class Kaffedrikkere implements Runnable{
    Bord bord;
    int id;

    public Kaffedrikkere(Bord bord, int id){
        this.bord = bord;
        this.id = id;
    }

    @Override
    public void run() {
        int teller = 0;
        String kaffe = bord.hentKaffe();
        while (!kaffe.equals("tomt")){
            System.out.println("Kaffedrikker " + id + ": drikker en " + kaffe);
            teller++;
            kaffe = bord.hentKaffe();
        }
            System.out.println("Kaffedrikker " + id + ": drakk " + teller + " kopper kaffe.");
    }
}
