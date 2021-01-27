package oblig1;

public class Hovedprogram {
    public static void main(String[] args) {
        Dataklynge abel = new Dataklynge(12);

        for (int i = 0; i<650; i++){
            abel.settInnNode(new Node(64,1));
        }

        for (int i = 0; i<16; i++){
            abel.settInnNode(new Node(1024,2));
        }

        System.out.println(abel.antProsessorer());
    }
}
