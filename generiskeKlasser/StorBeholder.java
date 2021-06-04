package generiskeKlasser;

public class StorBeholder <T>{
    @SuppressWarnings("unchecked")
    private T[] alle;
    private int antall = 0;

    public StorBeholder(int arrayStorrelse){
        alle = (T[]) new Object[arrayStorrelse];
    }

    public void settInn(T det){
        alle[antall] = det;
        antall++;
    }

    public T taUt(){
        antall--;
        return alle[antall];
    }

}
