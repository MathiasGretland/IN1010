package utfordringer;

public class Parkeringsplass <T>{
    T kjoretoy;

    public void parker(T k){
        kjoretoy = k;
    }

    public T hentKjoretoy(){
        return kjoretoy;
    }

    public T kjorUt(){
        T midl = kjoretoy;
        kjoretoy = null;
        return midl;
    }

    public static void main(String[] args) {
        Parkeringsplass<Bil> bilParkeringsplass = new Parkeringsplass<>();
        Parkeringsplass<Motorsykkel> motorsykkelParkeringsplass = new Parkeringsplass<>();

        bilParkeringsplass.parker(new Bil("KUSH420", 5));
        motorsykkelParkeringsplass.parker(new Motorsykkel("BUCKOOOOKAAAY", 230));

    }
}
