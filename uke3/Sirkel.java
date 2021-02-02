package uke3;

public class Sirkel extends Figur{
    private int radius;

    public Sirkel(int radius){
        this.radius = radius;
    }

    public double areal(){
        return radius*radius*Math.PI;
    }
}
