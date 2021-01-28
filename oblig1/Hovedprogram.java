package oblig1;

public class Hovedprogram {
    public static void main(String[] args) {
        //Dataklynge abel = new Dataklynge(12);
        Dataklynge fil = new Dataklynge("oblig1/dataklynge.txt");


        /*
        for (int i = 0; i<650; i++){
            abel.settInnNode(new Node(64,1));
        }

        for (int i = 0; i<16; i++){
            abel.settInnNode(new Node(1024,2));
        }
           */

        System.out.println("Noder med minst 32 GB: " + fil.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " + fil.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " + fil.noderMedNokMinne(128));

        System.out.println("Antall prosessorer: " + fil.antProsessorer());
        System.out.println("Antall rack: " + fil.antRacks());

    }
}
