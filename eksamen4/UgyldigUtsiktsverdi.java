package eksamen4;

public class UgyldigUtsiktsverdi extends RuntimeException{
    UgyldigUtsiktsverdi(int verdi){
        super("Ugyldig utsikts verdi: " + verdi);
    }
}
