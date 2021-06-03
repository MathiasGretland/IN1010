package interfaceRepetisjon;

public class Kaninbur implements KaninOppbevaring{
    private Kanin denne = null;

    @Override
    public boolean settInn(Kanin k){
        if (denne == null){
            denne = k;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Kanin taUt(){
        Kanin k = denne;
        denne = null;
        return k;
    }

    @Override
    public String toString(){
        String strenge = "Navn: " + denne.navn;
        return strenge;
    }

}
