package uke4;

public class Skyskraper extends Bygning{
    private int antallEtasjer;
    public Skyskraper(double bruttoAreal, int antallEtasjer){
        super(bruttoAreal);
        this.antallEtasjer = antallEtasjer;
        System.out.println("Dette er twin tower");

    }
}
