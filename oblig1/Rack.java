package oblig1;

public class Rack {
    //Private variabler som oppretter en Array med noder, antall noder og plasser.
    private Node [] noder;
    private int antallNoder = 0;
    private int plasser;

    //Konstruktøren
    // Når et Rack objekt lages, er man nødt til å angi hvor mange plasser Array'et skal ha
    public Rack(int plasser){
        noder = new Node[plasser];
        this.plasser = plasser;
    }

    //Returnerer hvor mange noder det er i racket
    public int getAntNoder(){
        int antNoder = 0;
        for (int i = 0; i < noder.length; i++){
            if (noder[i] != null){
                antNoder++;
            }
        }
        return antNoder;
    }

    //Beregner og returnerer hvormange antall prosessorer nodene i et rack har
    public int antProsessorer(){
        int antPros = 0;

        for (Node node : noder){
            if (node!= null){
                antPros += node.antProsessorer();
            }
        }
        return antPros;
    }

    //Beregner og returnerer antallet noder i racket med minne over en gitt mengde som man gis i paramteren
    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedNokMinne = 0;

        for (Node node : noder){
            if (node!= null){
                if (node.nokMinne(paakrevdMinne)) {
                    noderMedNokMinne++;
                }
            }

        }
        return noderMedNokMinne;
    }

    // Hjelpemetode for å gjøre settInnNode enklere
    // Returnerer en boolean avgjørende om det plass til flere noder i et rack eller ikke
    public boolean ledigPlass(){
        if (antallNoder < noder.length){
            return true;
        }return false;
    }

    // Hjelpemetode for å gjøre settInnNode enklere
    // Legger til en node i racket
    public void leggTilNode(Node node){
        noder[antallNoder] = node;
        antallNoder++;

    }

}
