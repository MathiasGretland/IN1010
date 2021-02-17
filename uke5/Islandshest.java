package uke5;

public class Islandshest extends Hest implements KanToelte,KanPasse{
    public Islandshest(String n, int a) {
        super(n, a);
    }

    @Override
    public void toelt() {
        System.out.println(navn + " TØLTER!");
    }

    @Override
    public void pass() {
        System.out.println(navn + " SPANKULERER BORTOVER VEIEN");
    }
}
