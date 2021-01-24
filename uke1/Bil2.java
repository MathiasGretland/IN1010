package uke1;

public class Bil2 {
    private String eier;
    private String merke;

    public Bil2(String e, String m) {
        eier = e;
        merke = m;
    }

    public void skrivUt() {
        System.out.println("Eier: " + eier);
        System.out.println("Merke: " + merke);
    }
}


