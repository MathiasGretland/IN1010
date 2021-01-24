package uke1;

public class BilTest2 {
    public static void main(String[] args) {
        Bil2 bil = new Bil2("Magnus", "Mercedes");
        Bil2 bil2 = new Bil2("Boris", "Toyota");
        bil.skrivUt();
        System.out.println();
        bil2.skrivUt();
    }
}