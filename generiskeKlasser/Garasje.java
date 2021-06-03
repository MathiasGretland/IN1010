package generiskeKlasser;

public class Garasje {
    private Bil denne;

    public boolean settInn(Bil den){
        if (denne == null){
            denne = den;
            return true;
        }
        else {
            return false;
        }
    }

    public Bil taUt(){
        return denne;
    }
}
