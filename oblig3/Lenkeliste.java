package oblig3;

public class Lenkeliste<T> implements Liste<T>{

    private Node start;

    class Node {
        Node neste;
        T data;

        Node(T x) {
            data = x;
        }
    }

    @Override
    public int stoerrelse() {
        int teller = 0;
        Node peker = start;
        while (peker != null){
            teller++;
            peker = peker.neste;
        }
        return teller;
    }

    @Override
    public void leggTil(int pos, T x) {
        //Hvis lista er tom, så er det bare å kjøre den andre leggTil metoden
        if (pos == 0 && stoerrelse() == 0){
            leggTil(x);
        }
        //Hvis posisjonen er lik størrelsen til lista så kan den bruke den andre leggTil metoden
        if (pos == stoerrelse()){
            leggTil(x);
        }


    }

    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);
        ny.neste = start;
        start = ny;
    }

    @Override
    public void sett(int pos, T x) {

    }

    @Override
    public T hent(int pos) {
        Node hentNode = start;
        for (int i = 0; i<pos; i++){
            hentNode = hentNode.neste;
        }
        return hentNode.data;
    }

    @Override
    public T fjern(int pos) {
        return null;
    }

    @Override
    public T fjern() {
        if (stoerrelse() <= 0)
            throw new UgyldigListeIndeks(-1);

        T data = start.data;
        start = start.neste;

        return data;
    }

    public String toString(){
        return "SWAG";
    }
}
