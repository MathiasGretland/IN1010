package traader;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinnAntall {
    String [] ord;
    int antallTraader = 8;
    CountDownLatch swagStopper;
    Lock laas = new ReentrantLock();
    int antallforekomster = 0;

    FinnAntall(CountDownLatch swagStopper){
        lesInnFil();
        this.swagStopper = swagStopper;
    }

    public void lesInnFil(){
        Scanner fil = null;
        String filnavn = "utfordringer/sevenrays.txt";
        try {
            fil = new Scanner(new File(filnavn));
        }catch (Exception e){
            System.out.println("Kan ikke finne fil " + filnavn + "!");
            System.exit(1);
        }
        String start = fil.nextLine();
        int arrayStorrelse = Integer.parseInt(start);
        ord = new String[arrayStorrelse];
        int teller = 0;
        while (fil.hasNextLine()){
            String input = fil.nextLine();
            input = input.replaceAll("[\\s+.,]","");
            ord[teller] = input;
            teller++;
        }
    }

    public void finnForekomster(String ordet){
        laas.lock();
        try {
            int teller = 0;
            for (String s : ord){
                String toLower = s.toLowerCase();
                if (toLower.equals(ordet)){
                    teller++;
                }
            }
            antallforekomster = teller;
        }finally {
            laas.unlock();
        }
    }

    public static void main(String[] args) {
        CountDownLatch swagStopper = new CountDownLatch(8);
        FinnAntall swag = new FinnAntall(swagStopper);
        String it = "they";
        FinnForekomster forekomster = new FinnForekomster(swag, it);
        for (int i = 0; i < swag.antallTraader; i++){
            Thread traad = new Thread(forekomster);
            traad.start();
            swag.swagStopper.countDown();
        }
        System.out.println(swag.antallforekomster);
    }
}
