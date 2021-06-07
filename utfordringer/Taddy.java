package utfordringer;

public class Taddy {

    public static boolean teddy(int n){
        if (n == 42){
            return true;
        }
        else {
            if (n % 2 == 0){
                teddy((n/2));
                return true;
            }
            else if (n % 3 == 0 || n % 4 == 0){
                int sisteSiffer = n % 10;
                int nestSisteSiffer = ((n%100)/10);
                int tall = sisteSiffer*nestSisteSiffer;
                teddy((n-tall));
                return true;
            }
            else if (n % 5 == 0){
                teddy((n-42));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(teddy(250));
        System.out.println(teddy(42));
        System.out.println(teddy(84));
        System.out.println(teddy(53));
        System.out.println(teddy(41));

    }
}
