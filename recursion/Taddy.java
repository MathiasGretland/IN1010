package recursion;

public class Taddy {
    public static boolean teddy(int n){
        int tall = 0;
        if (n == 42){
            return true;
        }
        else {
            if (n % 2 == 0){
                teddy(n/2);
            }
            else if (n % 3 == 0 || n % 3 == 0){
                int en = n % 10;
                int to = ((n%100)/10);
                teddy(en * to);
            }
            else if (n % 5 == 0){
                teddy(42);
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
