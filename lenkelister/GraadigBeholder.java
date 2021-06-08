package lenkelister;

public class GraadigBeholder implements Comparable<Katt>{
    Katt theOne = null;

    public Katt leggTil (Katt nyPus){
        if (theOne == null){
            theOne = nyPus;
            return null;
        }
        else if (theOne.compareTo(nyPus) > 0){
            return null;
        }
        else {
            Katt gamleTheOne = theOne;
            theOne = nyPus;
            return gamleTheOne;
        }
    }

    public Katt hvemErDerNaa(){
        return theOne;
    }

    @Override
    public int compareTo(Katt nyPus) {
        if (theOne.alder < nyPus.alder){
            return -1;
        }
        else if (theOne.alder > nyPus.alder){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GraadigBeholder beholder = new GraadigBeholder();

        beholder.leggTil(new Katt("Albert", 2));
        beholder.leggTil(new Katt("Oleksander", 3));
        beholder.leggTil(new Katt("Jeff", 8));
        beholder.leggTil(new Katt("Curry", 5));

        System.out.println(beholder.hvemErDerNaa());

    }
}
