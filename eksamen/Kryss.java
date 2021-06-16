package eksamen;

import java.util.ArrayList;

public class Kryss {
    ArrayList<Sti> listeMedStier = new ArrayList<>();

    public void leggTilSti(Sti sti){
        listeMedStier.add(sti);
    }

    public Sti hentTilfeldigSti(){
        if (listeMedStier.isEmpty()){
            return null;
        } else {
            return listeMedStier.get(Trekk.trekkInt(0, listeMedStier.size()-1));
        }
    }

    public boolean erIsolert(){
        if (listeMedStier.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
