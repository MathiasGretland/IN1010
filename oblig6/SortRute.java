package oblig6;

public class SortRute extends Rute{


    public SortRute(int rad, int kolonne, Labyrint labyrint) {
        super(rad, kolonne, labyrint);
    }

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

    boolean innenfor(int radNummer, int kolNummer){
        if ((radNummer < 0) || (kolNummer < 0)){
            return false;
        }

        if ((radNummer >= labyrint.rad) || (kolNummer >= labyrint.kolonne)){
            return false;
        }
        return true;
    }

    @Override
    char tilTegn() {
        return 0;
    }

    @Override
    void gaa() {

    }
}
