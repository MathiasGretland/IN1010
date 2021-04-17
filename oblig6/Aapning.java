package oblig6;

import java.util.ArrayList;

/**
 * Opprettet klassen Aapning som er en subklasse av klassen Rute
 */
public class Aapning extends HvitRute{

    /**
     * Konstruktøren til Aapning klassen
     * @param rad Tar inn rad, brukes til kordinater
     * @param kolonne Tar inn kolonne, brukes til kordinater
     * @param labyrint Tar inn et Labyrint objekt
     */
    public Aapning(int rad, int kolonne, Labyrint labyrint) {
        super(rad, kolonne, labyrint);
    }

    /**
     * Metoden finnNaboer bruker kordinater til å finne naboene (Nord, Sør, Øst og Vest) til Rute objekter
     * Bruker boolean metoden innenfor som avgjør om kordinatene er innenfor arrayet eller ikke.
     */
    @Override
    void finnNaboer() {
        if (innenfor(rad, kolonne + 1)){
            vest = labyrint.ruteArray[rad][kolonne + 1];
        } else {
            vest = null;
        }

        if (innenfor(rad + 1, kolonne)){
            sor = labyrint.ruteArray[rad + 1][kolonne];
        }
        else {
            sor = null;
        }

        if (innenfor(rad, kolonne - 1)){
            ost = labyrint.ruteArray[rad][kolonne - 1];
        }
        else {
            ost = null;
        }

        if (innenfor(rad-1, kolonne)){
            nord = labyrint.ruteArray[rad-1][kolonne];
        }
        else {
            nord = null;
        }


    }

    /**
     * Metoden innenfor avgjør om kordinatene er innenfor arrayet eller ikke.
     * @param radNummer Tar inn hvilket rad nummer
     * @param kolNummer Tar inn hvilket kolonne nummer
     * @return Returnerer true eller false basert på om det er innenfor arrayet eller ikke
     */
    boolean innenfor(int radNummer, int kolNummer){

        if ((radNummer < 0) || (kolNummer < 0)){
            return false;
        }

        if ((radNummer >= labyrint.rad) || (kolNummer >= labyrint.kolonne)){
            return false;
        }
        return true;
    }

    /**
     * Metoden tilTegn brukes til å skrive ut Rute-Objektet som en char
     * @return en char
     */
    @Override
    char tilTegn() {
        return '.';
    }

    /**
     * Metoden gaa som i tilfellet for Aapning Rute-objekter legger til posisjonen sin i arralisten og sender den til
     * ArrayList<ArrayList<Tuppel>> utveier som holder på alle veiene til aapninger.
     * @param sti tar inn et ArrayList av tuppler
     * @param forrigeKord Tar inn det forrige tuppelets kordinater
     */
    @Override
    void gaa(ArrayList<Tuppel> sti, Tuppel forrigeKord) {
        Tuppel her = new Tuppel(this.rad, this.kolonne);
        sti.add(her);
        labyrint.utveier.add(sti);
    }
}
