package uke12.regnetime;

public class Fakultet {

    static int regn(int tall){
        if (tall <= 0){
            return 1;
        }
        return tall * regn(tall-1);
    }

    public static void main(String[] args) {
        System.out.println(regn(7));
    }
}
