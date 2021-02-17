package uke5;

public class IkkeMerPlassException extends Exception {
    String boktittel;

    public IkkeMerPlassException(String boktittel) {
        super("Det var ikke mer plass til å sette inn " + boktittel);
    }
}
