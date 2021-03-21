package uke10.uke9gruppetime;

import java.util.Random;

public class Barista implements Runnable{
    private final String[] drikker = {"Americano","Cafe au lait","Cafe latte","Caffe mocca", "Espresso","Cortadp"};
    Bord bord;
    int id;

    public Barista(Bord bord, int id){
        this.bord = bord;
        this.id = id;
    }


    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            String kaffe = drikker[r.nextInt(drikker.length)];
            System.out.println("Barista " + id + ": lager en " + kaffe);
            bord.server(kaffe);
        }
        System.out.println("Det er tomt!");
    }
}
