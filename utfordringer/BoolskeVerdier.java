package utfordringer;

public class BoolskeVerdier {
    boolean sann = true;
    boolean usann = false;

    public void skrivSann(){
        System.out.println(sann);
    }

    public static void main(String[] args) {
        BoolskeVerdier boolskeVerdier = new BoolskeVerdier();
        boolskeVerdier.skrivSann();
    }
}
