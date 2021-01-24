package oblig0;

public class Person {

    private Bil3 personBil;

    public Person(Bil3 personBil) {
        this.personBil = personBil;
    }

    public void nummer(){
        System.out.println(personBil.hentNummer());
    }
}
