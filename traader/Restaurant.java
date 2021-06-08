package traader;

public class Restaurant {
    public static void main(String[] args){
        FellesBord bord = new FellesBord();
        Runnable servere = new Servere(bord,50);
        Runnable kokelere = new Kokelere(bord,50);
        Thread kokk = new Thread(kokelere);
        Thread enAnnenKokk = new Thread(kokelere);
        Thread servitor = new Thread(servere);
        Thread enAnnenServitor = new Thread(servere);
        kokk.start();
        enAnnenKokk.start();
        servitor.start();
        enAnnenServitor.start();
        System.out.println("Programmet er ferdig");
    }
}
