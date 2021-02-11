package oblig2;

public abstract class Resept {
    protected int Id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
    }

    public int hentId(){
        return Id;
    }

    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }

    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    public int hentPasientId(){
        return this.pasientId;
    }

    public int hentReit(){
        return this.reit;
    }

    public boolean bruk(){
        if (reit > 0){
            reit -= 1;
            return true;
        } return false;
    }

    abstract public String farge();

    abstract public int prisAaBetale();
}
