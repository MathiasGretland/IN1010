package uke3;

public class Rektangel extends Figur{
    private int bredde;
    private int hoyde;

    public Rektangel(int bredde, int hoyde){
        this.bredde = bredde;
        this.hoyde = hoyde;
    }

    public double areal(){
        return hoyde*bredde;
    }
}
