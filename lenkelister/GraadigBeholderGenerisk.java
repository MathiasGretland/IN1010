package lenkelister;

public class GraadigBeholderGenerisk <T extends Comparable<T>> {
    T theOne;

    public T leggTil (T nyT){
        if (theOne == null){
            theOne = nyT;
            return null;
        }
        else if (theOne.compareTo(nyT) > 0){
            return null;
        }
        else {
            T gamleTheOne = theOne;
            theOne = nyT;
            return gamleTheOne;
        }
    }

    public T hvemErDerNaa(){
        return theOne;
    }

    public static void main(String[] args) {
        GraadigBeholderGenerisk<Katt> beholder = new GraadigBeholderGenerisk();

        beholder.leggTil(new Katt("Albert", 2));
        beholder.leggTil(new Katt("Oleksander", 3));
        beholder.leggTil(new Katt("Jeff", 8));
        System.out.println(beholder.leggTil(new Katt("Curry", 5)));

        System.out.println(beholder.hvemErDerNaa());


    }
}
