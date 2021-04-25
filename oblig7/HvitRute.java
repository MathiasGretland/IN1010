package oblig7;

import java.util.ArrayList;

/**
 * Opprettet klassen HvitRute som er en subklasse av klassen Rute
 */
public class HvitRute extends Rute {

    /**
     * Konstruktøren til HvitRute klassen
     * @param rad Tar inn rad, brukes til kordinater
     * @param kolonne Tar inn kolonne, brukes til kordinater
     * @param labyrint Tar inn et Labyrint objekt
     */
    public HvitRute(int rad, int kolonne, Labyrint labyrint) {
        super(rad, kolonne, labyrint);
    }

    /**
     * Metoden finnNaboer bruker kordinater til å finne naboene (Nord, Sør, Øst og Vest) til Rute objekter
     * Bruker boolean metoden innenfor som avgjør om kordinatene er innenfor arrayet eller ikke.
     */
    @Override
    void finnNaboer() {
        if (innenfor(rad, kolonne + 1)) {
            vest = labyrint.ruteArray[rad][kolonne + 1];
        } else {
            vest = null;
        }

        if (innenfor(rad + 1, kolonne)) {
            sor = labyrint.ruteArray[rad + 1][kolonne];
        } else {
            sor = null;
        }

        if (innenfor(rad, kolonne - 1)) {
            ost = labyrint.ruteArray[rad][kolonne - 1];
        } else {
            ost = null;
        }

        if (innenfor(rad - 1, kolonne)) {
            nord = labyrint.ruteArray[rad - 1][kolonne];
        } else {
            nord = null;
        }
    }

    /**
     * Metoden innenfor avgjør om kordinatene er innenfor arrayet eller ikke.
     * @param radNummer Tar inn hvilket rad nummer
     * @param kolNummer Tar inn hvilket kolonne nummer
     * @return Returnerer true eller false basert på om det er innenfor arrayet eller ikke
     */
    boolean innenfor(int radNummer, int kolNummer) {
        if ((radNummer < 0) || (kolNummer < 0)) {
            return false;
        }
        if ((radNummer >= labyrint.rad) || (kolNummer >= labyrint.kolonne)) {
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
     * Metoden gaa som i tilfellet for HvitRute skal gå videre til neste HviteRute, og sånn fortsetter den helt til den kommer til en aapning
     * @param sti tar inn et ArrayList av tuppler
     * @param forrigeKord Tar inn det forrige tuppelets kordinater
     */
    @Override
    void gaa(ArrayList<Tuppel> sti, Tuppel forrigeKord) {
        Tuppel tuppel = new Tuppel(this.rad, this.kolonne);
        sti.add(tuppel);

        if (!(nord.rad == forrigeKord.rad && nord.kolonne == forrigeKord.kolonne)){
            ArrayList<Tuppel> nySti = new ArrayList<>(sti);
            nord.gaa(nySti, tuppel);
        }

        if (!(sor.rad == forrigeKord.rad && sor.kolonne == forrigeKord.kolonne)){
            ArrayList<Tuppel> nySti = new ArrayList<>(sti);
            sor.gaa(nySti,tuppel);
        }

        if (!(vest.rad == forrigeKord.rad && vest.kolonne == forrigeKord.kolonne)){
            ArrayList<Tuppel> nySti = new ArrayList<>(sti);
            vest.gaa(nySti,tuppel);
        }

        if (!(ost.rad == forrigeKord.rad && ost.kolonne == forrigeKord.kolonne)){
            ArrayList<Tuppel> nySti = new ArrayList<>(sti);
            ost.gaa(nySti,tuppel);
        }
    }
}
