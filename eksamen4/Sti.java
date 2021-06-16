package eksamen4;

public abstract class Sti {
    int lengde;
    Kryss fra;
    Kryss til;

    Sti(int lengde, Kryss fra, Kryss til){
        this.lengde = lengde;
        this.fra = fra;
        this.til = til;
    }

    public Kryss finnAndreEnde(){
        return til;
    }

    public int beregnGaaTid(int fart){
        return (lengde/fart);
    }
}
