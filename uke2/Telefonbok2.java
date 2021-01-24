package uke2;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;

public class Telefonbok2 {
    public static void main(String[] args) {
        Person kent = new Person("Kent", "94237261", "Torggata 21");
        Person are = new Person("Are", "27162734", "Torggata 43");
        Person jon = new Person("Jon", "73849122", "Torggata 83");

        /* Vanlig Array
        Person[] pliste = new Person[10];

        pliste[0] = kent;
        pliste[1] = are;
        pliste[2] = jon;

        for (int i = 0; i < pliste.length; i++){
            if (pliste[i] != null) {
                pliste[i].skrivInfo();
            }
        }
         */

        /* ArrayList
        ArrayList<Person> telefonliste = new ArrayList<>();
            telefonliste.add(kent);
            telefonliste.add(are);
            telefonliste.add(jon);

            for (Person p : telefonliste) {
                p.skrivInfo();
            }

         */

        HashMap<String, Person> telefonbok = new HashMap<>();

        telefonbok.put(kent.hentNavn(), kent);
        telefonbok.put(are.hentNavn(), are);
        telefonbok.put(jon.hentNavn(), jon);

        for (Person p : telefonbok.values()) {
            p.skrivInfo();
        }
    }
}
