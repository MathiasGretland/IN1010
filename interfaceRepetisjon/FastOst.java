package interfaceRepetisjon;

public class FastOst implements Importavgiftspliktig{
    private int fettpr;
    private String navn;
    private long kg;
    private int importprisPerKg;

    FastOst(int fettpr, String navn, long kg, int importprisPerKg){
        this.fettpr = fettpr;
        this.navn = navn;
        this.kg = kg;
        this.importprisPerKg = importprisPerKg;
    }

    public int fettprosent(){
        return fettpr;
    }

    public String navn(){
        return navn;
    }

    @Override
    public int avgift() {
        return Math.round(importprisPerKg * kg * 2.77F);
    }

    @Override
    public int pris() {
        return (Math.round(importprisPerKg*kg) + avgift());
    }
}
