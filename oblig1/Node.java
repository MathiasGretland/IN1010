package oblig1;

public class Node {
    //Private variabler som avgjør hvor mye minne og antall prosessorer hver Node har
    private int minne;
    private int antPros;

    //Konstruktøren
    public Node(int minne, int antPros){
        this.minne = minne;
        this.antPros = antPros;
    }

    //Henter antall prosessorer i noden
    public int antProsessorer(){
        return antPros;
    }

    //Sjekker om noden har tilstrekkelig minne for et program
    public boolean nokMinne(int paakrevdMinne){
        if (minne >= paakrevdMinne){
            return true;
        }return false;
    }
}
