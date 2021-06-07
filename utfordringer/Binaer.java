package utfordringer;

public class Binaer {

    public static void skrivUtBinaer(int n){
        if (n == 0){
            return;
        }
        else {
            if (n % 2 == 0){
                skrivUtBinaer((n/2));
                System.out.print(0);
            }else {
                skrivUtBinaer((n/2));
                System.out.print(1);
            }
        }
    }

    public static void main(String[] args) {
        skrivUtBinaer(20);
    }
}
