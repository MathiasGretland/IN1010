package interfaceRepetisjon;

import java.util.HashMap;

public class Bil implements Importavgiftspliktig{
    private String registNr;
    private String eier;
    private int importprisen;
    

    Bil(String registNr, int importprisen){
        this.registNr = registNr;
        this.importprisen = importprisen ;
    }

    public void nyEier(String ei){
        eier = ei;
    }

    public String regNr(){
        return registNr;
    }

    @Override
    public int avgift() {
        return importprisen;
    }

    @Override
    public int pris() {
        return (importprisen + avgift());
    }
}

