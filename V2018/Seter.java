package V2018;

public class Seter implements MidtgangSete{
    Passasjer eier;

    boolean erVindussete(){
        return true;
    }

    @Override
    public boolean erVedMidtgang() {
        return false;
    }
}
