package V2018;

public class Passasjer {
    String navn;
    double hoyde;

    public Passasjer(String navn, double hoyde){
        this.navn = navn;
        this.hoyde = hoyde;
    }

    boolean harLangeBen(){
        if (hoyde >= 190){
            return true;
        }
        return false;
    }
}
