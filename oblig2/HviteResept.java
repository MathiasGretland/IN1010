package oblig2;

/**
 * Oppretter den abstracte classen HviteResept som er en subklasse av Resept
 */
public abstract class HviteResept extends Resept{
    /**
     * Oppretter konstruktøren, og tar med paramterne fra super klassen
     */
    public HviteResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    /**
     *Overrider metoden: farge() fra superklassen, og returnerer Stringer "hvit"
     */
    @Override
    public String farge() {
        return "hvit";
    }

    /**
     *Overrider metoden: prisAaBetale() fra superklassen, og returnerer det som pasienten skal betale
     */
    @Override
    public int prisAaBetale() {
        return 0;
    }
}
