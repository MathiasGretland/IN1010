package eksamen;

public class NaturstierMedGodUtsikt extends Naturstier implements GodUtsikt{
    int utsiktsVerdi;

    NaturstierMedGodUtsikt(int lengde, Kryss fra, Kryss til, int utsiktsVerdi){
        super(lengde, fra, til);
        if (utsiktsVerdi < 1 || utsiktsVerdi > 6){
            throw new UgyldigUtsiktsverdi(utsiktsVerdi);
        }
        this.utsiktsVerdi = utsiktsVerdi;
    }

    @Override
    public int hentUtsiktsverdi() {
        return utsiktsVerdi;
    }
}
