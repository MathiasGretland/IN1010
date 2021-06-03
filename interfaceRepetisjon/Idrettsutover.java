package interfaceRepetisjon;

public class Idrettsutover implements Konkurransedeltager{
    private String navn;


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
