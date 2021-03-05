package uke8;

public class Person implements Comparable<Person>{
    String navn;
    int fodselesaar;
    Person mor;
    Person far;

    public Person(int fodselesaar, String navn, Person mor, Person far){
        this.navn = navn;
        this.fodselesaar = fodselesaar;
        this.mor = mor;
        this.far = far;
    }

    public String hentNavn(){
        return this.navn;
    }

    public int hentFodselsaar(){
        return this.fodselesaar;
    }

    public Person hentMor(){
        return this.mor;
    }

    public Person hentFar(){
        return this.far;
    }

    public Person finnEldsteKjenteForfader(){
        if (mor == null){
            if (far == null) {
                return this;
            }
            return far.finnEldsteKjenteForfader();
        }
        if (far == null){
            return mor.finnEldsteKjenteForfader();
        }

        if (mor.finnEldsteKjenteForfader().compareTo(far.finnEldsteKjenteForfader()) < 0){
            return mor.finnEldsteKjenteForfader();
        } else {
            return far.finnEldsteKjenteForfader();
        }

    }

    @Override
    public String toString(){
        return "Navn: " + hentNavn() + "\nFødselsår: " + hentFodselsaar() + "\nMor: " + hentMor() + "\nFar: " + hentFar();
    }

    @Override
    public int compareTo(Person nyPerson) {
        int verdi = 0;
        // nyPerson er eldst
        if (this.fodselesaar < nyPerson.fodselesaar){
            verdi = -1;
        }
        // Denne personen er eldst
        else if (this.fodselesaar > nyPerson.fodselesaar){
            verdi = 1;
        }
        return verdi;
    }
}
