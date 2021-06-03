package interfaceRepetisjon;

public class Veddelopshest implements Konkurransedeltager{
    private int hestNr;
    private String eier;

    @Override
    public int startnummer() {
        return 0;
    }

    @Override
    public int resultatnummer() {
        return 0;
    }

    @Override
    public float tid() {
        return 0;
    }
}
