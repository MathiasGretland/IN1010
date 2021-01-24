package uke2;

public class Heltallsarray {
    public static void main(String[] args) {
        int tall1 = 0;
        int tall2 = 1;
        int tall3 = 2;
        int tall4 = 3;
        int tall5 = 4;

        System.out.println("Utskrift av variable:");
        System.out.println("tall1 = " + tall1);
        System.out.println("tall2 = " + tall2);
        System.out.println("tall3 = " + tall3);
        System.out.println("tall4 = " + tall4);
        System.out.println("tall5 = " + tall5);

        /*
        Koden nedenfor er uavhengig av koden ovenfor
         */
        int array [] = new int [5];

        int lengdePaaArray = array.length;
        int teller = 0;
        while (teller < lengdePaaArray) {
            array[teller] = teller;
            teller++;
        }

        teller = 0;
        System.out.println("Utskrift av array:");
        while (teller < lengdePaaArray){
            System.out.println("Array[" + teller + "] = " + array[teller]);
            teller++;
        }
    }
}
