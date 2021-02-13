package oblig2;

/**
 * Oppretter den abstracte classen Legemiddel
 * Inneholder alle variblene den trenger
 */
public abstract class Legemiddel {
    protected String navn;
    protected int pris;
    protected int id;
    protected double virkestoff;

    /**
     * Oppretter konstruktøren, med parameterne den skal ha.
     */
    public Legemiddel(String navn, int pris,int id, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.id = id;
        this.virkestoff = virkestoff;

    }

    /**
     *Returnerer this.id
     */
    public int hentId(){
        return this.id;
    }

    /**
     * Returnerer this.navn
     */
    public String hentNavn(){
        return this.navn;
    }

    /**
     * Returnerer this.pris
     */
    public int hentPris(){
        return this.pris;
    }

    /**
     * Returnerer this.virkestoff
     */
    public double hentVirkestoff(){
        return this.virkestoff;
    }

    /**
     * Returnerer en ny pris, som man skriver inn i parameteren.
     */
    public int settNyPris(int nyPris){
        return this.pris = nyPris;
    }
}
