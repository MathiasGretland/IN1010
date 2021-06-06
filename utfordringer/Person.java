package utfordringer;

public class Person {
    String navn;

    Person(String navn){
        this.navn = navn;
    }

    public String hentNavn(){
        return navn;
    }
}
