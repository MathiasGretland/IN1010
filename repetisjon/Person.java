package repetisjon;

import java.util.Iterator;

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

    @Override
    public String toString(){
        return navn + " med gjenstand " + gjenstand;
    }

}

class Butikk implements Iterable<Person>{
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

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person>{
        private Person denne;

        public PersonIterator(){
            denne = forstePerson;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public Person next() {
            Person midlr = denne;
            denne = denne.hentNeste();
            return midlr;
        }
    }

    public static void main(String[] args) {
        Butikk butikk = new Butikk();

        butikk.entreButikk(new Person("Stig", "Sitronsaft"));
        butikk.entreButikk(new Person("Hedda", "Engangskopper"));
        butikk.entreButikk(new Person("Jack", "PASTA"));
        butikk.entreButikk(new Person("Henrik", "KAFFE"));
        butikk.entreButikk(new Person("Magnus", "Tomatsuppe"));

        System.out.println("Personer i butikken:");

        for (Person p : butikk){
            System.out.println(p);
        }

    }
}
