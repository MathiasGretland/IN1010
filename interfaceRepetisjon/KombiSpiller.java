package interfaceRepetisjon;

public class KombiSpiller implements Radio,MP3Spiller{

    private int vekten = 125;
    private boolean av = true;
    private int lydstyrke = 0;

    @Override
    public void setAlbum(String albumnavn) {

    }

    @Override
    public void setSang(String sang) {

    }

    @Override
    public boolean trykkAvPaKnapp() {
        av = !av;
        return av;
    }

    @Override
    public void justerLyd(int forandring) {
        lydstyrke += forandring;
    }

    @Override
    public void setKanal(String kanalNavn) {

    }

    public int vekt(){
        return vekten;
    }
}
