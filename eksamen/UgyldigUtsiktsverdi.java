package eksamen;

public class UgyldigUtsiktsverdi extends RuntimeException{
    UgyldigUtsiktsverdi(int verdi){
        super("Ugyldig utsikts verdi: " + verdi);
    }
}
