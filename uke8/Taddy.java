package uke8;

public class Taddy {
    public static void main(String[] args) {
        System.out.println(teddy(250));
        System.out.println(teddy(42));
        System.out.println(teddy(84));
        System.out.println(teddy(53));
        System.out.println(teddy(41));
    }

    public static boolean teddy(int n){
        boolean tady = true;
        int antallTady = n;
        int nestSisteSiffer = (n%100)/10;
        int sisteSiffer = n % 10;
        int gange = nestSisteSiffer*sisteSiffer;
        if (n % 2 == 0){
            antallTady = n/2;
        }
        else if (n % 3 == 0){
            antallTady -= gange;
        }

        else if (n % 5 == 0){
            antallTady -= 42;
        }

        else {
            tady = false;
        }
        return tady;
    }

}
