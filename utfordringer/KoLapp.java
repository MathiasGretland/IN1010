package utfordringer;

public class KoLapp{
    private static int antProd = 1;
    private int nummer;

    //Konstruktor
    public KoLapp(){
        nummer = antProd;
        antProd++;
    }

    //Returnerer et tildelt nummer paa kolappen.
    public int hentNummer(){
        return nummer;
    }
}