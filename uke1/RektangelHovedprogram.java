package uke1;

public class RektangelHovedprogram {
    public static void main(String[] args) {
        Rektangel en = new Rektangel(5, 10);
        Rektangel to = new Rektangel(3, 7);

        System.out.println("Areal: " + en.areal());
        System.out.println("Areal: " + to.areal());

        en.oekLengde(4);
        to.oekBredde(7);

        System.out.println("Omkrets: " + en.omkrets());
        System.out.println("Omkrets: " + to.omkrets());
    }
}
