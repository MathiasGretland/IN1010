package uke12.regnetime;

public class Menneske {
    Menneske far;
    Menneske mor;
    String navn;
    int alder;

    public Menneske(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
        this.far = null;
        this.mor = null;
    }

    public void settFar(Menneske far){
        this.far = far;
    }

    public void settMor(Menneske mor){
        this.mor = mor;
    }

    // Finner person oppover i familietre som har blitt eldst.
    public Menneske finnEldstePersonIForgrening(){

        // Basissteg: dersom ingen foreldre er kjente
        if (mor == null && far == null){
            return this;
        }
        Menneske eldstPaaMorSide = mor;
        Menneske eldstPaaFarSide = far;
        if (mor != null){
            eldstPaaMorSide = mor.finnEldstePersonIForgrening();
        }
        if (far != null) {
            eldstPaaFarSide = far.finnEldstePersonIForgrening();
        }

        Menneske eldstePerson = this;

        if (eldstPaaMorSide != null) {
            if (eldstePerson.alder < eldstPaaMorSide.alder) {
                eldstePerson = eldstPaaMorSide;
            }
        }

        if (eldstPaaFarSide != null) {
            if (eldstePerson.alder < eldstPaaFarSide.alder) {
                eldstePerson = eldstPaaFarSide;
            }
        }

        return eldstePerson;
    }


    @Override
    public String toString(){
        String streng = "Navn: " + navn;
        streng += "\nAlder: " + alder + "\n";
        return streng;
    }


    public String familieTre(){
        String stringen = "Navn: " + navn + "\n" + "Alder: " + alder + "\n";
        if (mor != null) {
            stringen += mor.familieTre();
        }
        if (far != null) {
            stringen += far.familieTre();
        }

        return stringen;
    }

}
