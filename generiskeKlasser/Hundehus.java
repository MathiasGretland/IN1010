package generiskeKlasser;

public class Hundehus {
    private Hund denne;
    public void settInn(Hund den){
        if (denne == null){
            denne = den;
        }
        else {
            System.out.println("DET ER FULLT!");
        }
    }

    public Hund taUt(){
        return denne;
    }
}
