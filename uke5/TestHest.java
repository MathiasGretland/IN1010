package uke5;

public class TestHest {
    public static void main(String[] args) {
        EngelskFullblodshest aleksander = new EngelskFullblodshest("Aleksander", 12);
        PasoFino hoff = new PasoFino("Hoff", 11);
        Islandshest gagsy = new Islandshest("Gægsy", 12);

        aleksander.galopp();
        aleksander.skritt();
        aleksander.trav();
        System.out.println();
        hoff.toelt();
        hoff.skritt();
        System.out.println();
        gagsy.pass();
        gagsy.toelt();
    }
}
