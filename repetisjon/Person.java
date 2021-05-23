package repetisjon;

public class Person {
    String navn;
    String gjenstand;
    Person nestePerson;

    public Person(String navn, String gjenstand){
        this.navn = navn;
        this.gjenstand = gjenstand;
    }

    public void settNestePerson(Person nyNestePerson){
        nestePerson = nyNestePerson;
    }

    public Person hentNeste(){
        return this.nestePerson;
    }

    public String toString(){
        return navn + " med gjenstand " + gjenstand;
    }

    public static void main(String[] args) {
        Butikk butikk = new Butikk();

        butikk.entreButikk(new Person("Stig", "Sitronsaft"));
        butikk.entreButikk(new Person("Hedda", "Engangskopper"));
        butikk.entreButikk(new Person("Jack", "PASTA"));
        butikk.entreButikk(new Person("Henrik", "KAFFE"));
        butikk.entreButikk(new Person("Magnus", "Tomatsuppe"));

        butikk.kassa();

    }


}

class Butikk {
    Person forstePerson;

    public void entreButikk(Person p){
        if (forstePerson == null){
            forstePerson = p;
        }else {
            Person midlertidig = forstePerson;
            while (midlertidig.hentNeste() != null){
                midlertidig = midlertidig.hentNeste();
            }
            midlertidig.settNestePerson(p);
        }
    }

    public void kassa(){
        while (forstePerson != null){
            System.out.println("Behandler kunde: " + forstePerson);
            System.out.println("- Hade bra!");
            forstePerson = forstePerson.hentNeste();
        }
        System.out.println("Tomt for kunder");
    }

}
