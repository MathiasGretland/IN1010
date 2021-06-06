package utfordringer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonOgHundeListe {
    ArrayList<Person> personer = new ArrayList<>();
    ArrayList<Hund> hunder = new ArrayList<>();

    PersonOgHundeListe(){
        lesInnFil();
    }

    public void lesInnFil(){
        Scanner fil = null;
        String filnavn = "utfordringer/navn.txt";
        try {
            fil = new Scanner(new File(filnavn));
        } catch (Exception e){
            System.out.println("Finner ikke filen " + filnavn + "!");
            System.exit(1);
        }
        while (fil.hasNextLine()){
            String input = fil.nextLine();
            String[] data = input.split(" ");
            String menneskeEllerHund = data[0];
            String navn = data[1];
            if (menneskeEllerHund.equals("P")){
                Person nyPerson = new Person(navn);
                personer.add(nyPerson);
            }else {
                Hund nyHund = new Hund(navn);
                hunder.add(nyHund);
            }
        }
    }

    public void skrivPersoner(){
        for (Person p : personer){
            System.out.println("Navn: " + p.hentNavn());
        }
    }

    public void skrivHunder(){
        for (Hund h : hunder){
            System.out.println("Navn: " + h.hentNavn());
        }
    }

    public static void main(String[] args) {
        PersonOgHundeListe swag = new PersonOgHundeListe();
        swag.skrivPersoner();
        System.out.println();
        swag.skrivHunder();
    }
}
