package oblig1;

public class Node {
    private int minne;
    private int antPros;

    public Node(int minne, int antPros){
        this.minne = minne;
        this.antPros = antPros;
    }

    public int antProsessorer(){
        return antPros;
    }

    public boolean nokMinne(int paakrevdMinne){
        if (minne >= paakrevdMinne){
            return true;
        }return false;
    }
}
