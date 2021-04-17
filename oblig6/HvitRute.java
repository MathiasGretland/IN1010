package oblig6;

import java.util.ArrayList;

public class HvitRute extends Rute {


    public HvitRute(int rad, int kolonne, Labyrint labyrint) {
        super(rad, kolonne, labyrint);
    }

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

    boolean innenfor(int radNummer, int kolNummer) {
        if ((radNummer < 0) || (kolNummer < 0)) {
            return false;
        }
        if ((radNummer >= labyrint.rad) || (kolNummer >= labyrint.kolonne)) {
            return false;
        }
        return true;
    }

    @Override
    char tilTegn() {
        return '.';
    }

    @Override
    void gaa(ArrayList<Tuppel> sti, Tuppel forrigeKord) {
        Tuppel tuppel = new Tuppel(this.rad, this.kolonne);
        sti.add(tuppel);
        ArrayList<Tuppel> nySti = new ArrayList<>(sti);

        for (Tuppel t : sti) {
            if (t.equals(forrigeKord)) {
                return;
            } else {
                nord.gaa(nySti, tuppel);
            }
            if (t.equals(forrigeKord)) {
                return;
            } else {
                sor.gaa(nySti, tuppel);
            }
            if (t.equals(forrigeKord)) {
                return;
            } else {
                ost.gaa(nySti, tuppel);
            }
            if (t.equals(forrigeKord)) {
                return;
            } else {
                vest.gaa(nySti, tuppel);
            }
        }
    }
}
