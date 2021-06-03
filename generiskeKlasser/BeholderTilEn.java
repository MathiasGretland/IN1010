package generiskeKlasser;

public class BeholderTilEn <T>{
    private T denne;

    public void settInn(T den){
        if (denne == null){
            denne = den;
        }
        else {
            System.out.println("DET ER FULLT");
        }
    }

    public T taUt(){
        return denne;
    }
}
