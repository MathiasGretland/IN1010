package oblig2;

public abstract class Legemiddel {
    protected String navn;
    protected int pris;
    protected int id;
    protected double virkestoff;
    public Legemiddel(String navn, int pris,int id, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.id = id;
        this.virkestoff = virkestoff;

    }

    public int hentId(){
        return this.id;
    }

    public String hentNavn(){
        return this.navn;
    }

    public int hentPris(){
        return this.pris;
    }

    public double hentVirkestoff(){
        return this.virkestoff;
    }

    public int settNyPris(int nyPris){
        return this.pris = nyPris;
    }
}
