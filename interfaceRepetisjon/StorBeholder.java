package interfaceRepetisjon;

public class StorBeholder <E> implements GenereiskInterface <E>{
    @SuppressWarnings("unchecked")
    private E [] alle;
    private int antall = 0;
    private int storreleArray;

    public StorBeholder(int storrelseArray){
        this.storreleArray = storrelseArray;
        alle = (E[]) new Object[storrelseArray];
    }

    @Override
    public boolean settInn(E den) {
        if (antall == storreleArray){
            return false;
        }
        alle[antall] = den;
        antall++;
        return true;
    }

    @Override
    public E taUt() {
        if (antall == 0){
            return null;
        }
        antall--;
        return alle[antall];
    }
}
