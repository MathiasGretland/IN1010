package uke3;

public class Kvadrat extends Figur{
    private int sideLengde;

    public Kvadrat(int sideLengde){
        this.sideLengde = sideLengde;
    }

    public double areal(){
        return sideLengde*sideLengde;
    }
}
