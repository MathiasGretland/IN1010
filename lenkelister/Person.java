package lenkelister;

public class Person {
    String navn;
    String gjenstand;
    Person neste = null;

    Person(String navn, String gjenstand){
        this.navn = navn;
        this.gjenstand = gjenstand;
    }

    public String toString(){
        String strenge = "Navn: " + navn;
        strenge += "\nGjenstand: " + gjenstand;
        if (neste != null){
            strenge += "\nNeste Person: " + neste.navn + "\n";
        }else {
            strenge += "\nIngen flere kunder";
        }
        return strenge;
    }

}
