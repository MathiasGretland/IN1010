package uke5;

public class TestFigurer {
    public static void main(String[] args) {
        Rektangel r1 = new Rektangel(10.2, 15.7);
        Rektangel r2 = new Rektangel(5.6, 7);

        Sirkel s1 = new Sirkel(5.4);
        Sirkel s2 = new Sirkel(4.7);


        System.out.println(r1.beregnAreal());
        System.out.println(r2.beregnOmkrets());

        System.out.println(s2.beregnAreal());
        System.out.println(s2.beregnOmkrets());
    }
}
