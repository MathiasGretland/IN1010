package proveeksamen;

public class PasientTabell extends PasientAdm{
    Pasient[] pasientArray;
    int sengePos;

    PasientTabell(int lengdePaaListe){
        pasientArray = new Pasient[lengdePaaListe];
    }

    @Override
    public void settInnPasient(Pasient p) {
        int startPos = sengePos;
        while (true){
            if (pasientArray[startPos] == null){
                pasientArray[startPos] = p;
                p.sengNr = sengePos;
                return;
            }
            sengePos++;
            if (sengePos >= pasientArray.length){
                sengePos = 0;
            }
            if (sengePos == startPos){
                return;
            }
        }
    }

    @Override
    public Pasient hentUt(Pasient p) {
        pasientArray[p.sengNr] = null;
        p.sengNr = -1;
        return p;
    }

    @Override
    public Pasient hentUt(int i) {
        for (int y = 0; y < pasientArray.length; y++){
            if (pasientArray[y] != null && pasientArray[y].prioritet == i){
                Pasient p = pasientArray[y];
                p.sengNr = -1;
                pasientArray[y] = null;
                return p;
            }
        }
        return null;
    }
}
