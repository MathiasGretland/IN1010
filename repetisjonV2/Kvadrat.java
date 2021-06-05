package repetisjonV2;

public class Kvadrat {

    double lengde;

    public Kvadrat(double lengde){
        this.lengde = lengde;
    }

    public double areal(){
        return lengde*lengde;
    }

    public double omkrets(){
        return 4*lengde;
    }
}
