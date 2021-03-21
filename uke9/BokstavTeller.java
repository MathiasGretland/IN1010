package uke9;


public class BokstavTeller implements Runnable{

    String ord;
    char bokstav;

    public BokstavTeller(String ord, char bokstav){
        this.ord = ord;
        this.bokstav = bokstav;
    }

    @Override
    public void run() {
        int teller = 0;
        String ordLower = ord.toLowerCase();
        for (int i = 0; i < ord.length(); i++){
            if (ordLower.charAt(i) == bokstav){
                teller++;
            }
        }
        System.out.println("I " + ord + " er det " + teller + " " + bokstav);
    }
}
