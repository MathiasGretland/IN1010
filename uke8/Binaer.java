package uke8;

public class Binaer {
    public static void main(String[] args) {

        skrivUtBinaer(27);


    }

    /*
    static void skrivUtBinaer(int n){
        String binaer = "";
        if (n == 0){
            System.out.println("0");
        }else {

            while (n != 0){

                if (n % 2 == 0){
                    binaer += "0";
                }
                else if (n % 2 == 1){
                    binaer += "1";
                }
                n = (n/2);
            }
        }
        System.out.println(binaer);
    }
     */

    static void skrivUtBinaer(int n){
        if(n == 0){
            System.out.print(0);
        }
        else {
            if(n > 1){
                skrivUtBinaer(n/2);
            }
            System.out.print(n%2);
        }
    }
}
