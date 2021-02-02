package uke3;

public class Trekant extends Figur{
    private int hoyde;
    private int bredde;

    public Trekant(int hoyde, int bredde){
        this.bredde = bredde;
        this.hoyde = hoyde;
    }

    public double areal(){
        return (bredde*hoyde)/2;
    }
}
