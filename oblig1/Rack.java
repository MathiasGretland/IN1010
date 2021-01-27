package oblig1;

public class Rack {
    private Node [] noder;
    private int antallNoder = 0;
    private int plasser;

    // Når et Rack objekt lages, er man nødt til å angi hvor mange plasser Array'et skal ha
    public Rack(int plasser){
        noder = new Node[plasser];
    }

    public int getAntNoder(){
        int antNoder = 0;
        for (int i = 0; i < noder.length; i++){
            if (noder[i] != null){
                antNoder++;
            }
        }
        return antNoder;
    }

    public int antProsessorer(){
        int antPros = 0;

        for (Node node : noder){
            if (node!= null){
                antPros += node.antProsessorer();
            }
        }
        return antPros;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedNokMinne = 0;

        for (Node node : noder){
            if (node.nokMinne(paakrevdMinne)) {
                noderMedNokMinne++;
            }
        }
        return noderMedNokMinne;
    }

    // Hjelpemetode for å gjøre settInnNode enklere
    public boolean ledigPlass(){
        if (antallNoder >= noder.length){
            return true;
        }return false;
    }
K
}
