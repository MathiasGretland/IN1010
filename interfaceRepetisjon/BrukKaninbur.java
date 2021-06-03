package interfaceRepetisjon;

public class BrukKaninbur {
    public static void main(String[] args) {

        //Dette er del 1
        /*
        KaninOppbevaring detGuleBuret = new Kaninbur();
        Kanin kalle = new Kanin("Kalle");
        detGuleBuret.settInn(kalle);

        KaninOppbevaring detStoreBuret;
        detStoreBuret = new Kaninbur();
        Kanin trofast = new Kanin("Pelle");
        detStoreBuret.settInn(trofast);

        System.out.println(detGuleBuret);
        System.out.println(detStoreBuret);

        Kanin forstUt = detGuleBuret.taUt();
        Kanin utAvStore = detStoreBuret.taUt();
        detStoreBuret.settInn(forstUt);
        detGuleBuret.settInn(utAvStore);


        System.out.println();
        System.out.println(detGuleBuret);
        System.out.println(detStoreBuret);
         */

        KaninburMedLys nyttBurLys = new KaninburMedLys();
        Kanin pelle = new Kanin("Pelle");
        nyttBurLys.settInn(pelle);
        nyttBurLys.tennLyset();
        Lys romMLys = nyttBurLys;
        romMLys.slukkLyset();
        romMLys.tennLyset();
        Kaninbur detNyeBuret;
        detNyeBuret = nyttBurLys;
        Kanin trofast;
        trofast = detNyeBuret.taUt();

    }
}
