package oblig2;

/**
 * Oppretter den abstracte classen Resept
 * Inneholder alle variblene den trenger
 */
public abstract class Resept {
    protected int Id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;

    /**
     * Oppretter konstruktøren, med parameterne den skal ha.
     */
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
    }

    /**
     * Returnerer this.id
     */
    public int hentId(){
        return Id;
    }

    /**
     * Returnerer this.legemiddel
     */
    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }

    /**
     * Returnerer this.utskrivendeLege
     */
    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    /**
     * Returnerer this.pasientId
     */
    public int hentPasientId(){
        return this.pasientId;
    }

    /**
     * Returnerer this.reit
     */
    public int hentReit(){
        return this.reit;
    }

    /**
     * Returnerer True eller False avhengig av om resepten har flere reit igjen
     */
    public boolean bruk(){
        if (reit > 0){
            reit -= 1;
            return true;
        } return false;
    }

    /**
     * Oppretter en abstract metode
     * Subklassene bruker denne til å avgjøre hvilken farge resepten har
     */
    abstract public String farge();

    /**
     * Oppretter en abstract metode
     * Subklassene bruker denne til å avgjøre hvor mye pasienten skal betale
     */
    abstract public int prisAaBetale();
}
