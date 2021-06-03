package interfaceRepetisjon;

public class KaninburMedLys extends Kaninbur implements Lys{
    private boolean lys = false;

    @Override
    public void tennLyset() {
        lys = true;
    }

    @Override
    public void slukkLyset() {
        lys = false;
    }
}
