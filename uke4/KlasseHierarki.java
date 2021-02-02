package uke4;

public class KlasseHierarki {
    public static void main(String[] args) {
        Bachelorstudenter CP = new Bachelorstudenter("Tomas GP", 13, "Barnehagelærer", "BI");
        CP.skrivInfo();
    }
}

abstract class Personer{
    private String navn;
    private int alder;

    public Personer(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public String navn(){
        return this.navn;
    }
    public abstract void skrivInfo();
}

class Studenter extends Personer{
    private String kurs;
    private String lerested;

    public Studenter(String navn, int alder, String kurs, String lerested){
        super(navn,alder);
        this.kurs = kurs;
        this.lerested = lerested;
    }

    @Override
    public void skrivInfo() {
        System.out.println(navn() + " er student.");
    }
}

class Bachelorstudenter extends Studenter{
    public Bachelorstudenter(String navn, int alder, String kurs, String lerested){
        super(navn,alder,kurs,lerested);

    }

    public boolean harTilgang(){
        return false;
    }

    @Override
    public void skrivInfo() {
        System.out.println("Bachelorstudentens info: " + navn());
    }

}

class Masterstudenter extends Studenter{
    public Masterstudenter(String navn, int alder, String kurs, String lerested){
        super(navn,alder,kurs,lerested);
    }

    public boolean harTilgang(){
        return true;
    }

    @Override
    public void skrivInfo() {
        System.out.println("Masterstudentens info: " + navn());
    }
}

class Ansatte extends Personer{
    private int timesLønn;
    public Ansatte(String navn, int alder, int timesLønn){
        super(navn, alder);
        this.timesLønn = timesLønn;
    }

    @Override
    public void skrivInfo() {

    }
}

class Forskere extends Ansatte{
    private String fagomrade;

    public Forskere(String navn, int alder, int timesLønn, String fagomrade){
        super(navn,alder,timesLønn);
        this.fagomrade = fagomrade;
    }

    @Override
    public void skrivInfo() {

    }
}

class Professorer extends Ansatte{
    private String fagomrade;
    private String kurs;

    private Professorer(String navn, int alder, int timesLønn, String fagomrade, String kurs){
        super(navn,alder,timesLønn);
        this.fagomrade = fagomrade;
        this.kurs = kurs;
    }

    @Override
    public void skrivInfo() {

    }
}