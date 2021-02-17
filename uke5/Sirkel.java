package uke5;

public class Sirkel implements Figur{
    private double radius;

    public Sirkel(double radius){
        this.radius = radius;
    }

    @Override
    public double beregnAreal() {
        return radius * radius * Math.PI;
    }

    @Override
    public double beregnOmkrets() {
        return radius * 2 * Math.PI;
    }
}
