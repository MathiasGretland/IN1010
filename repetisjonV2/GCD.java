package repetisjonV2;

public class GCD {

    static int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        int c = a % b;

        if (c == 0) {
            return b;
        } else {
            return gcd(b, c);
        }
    }

}
