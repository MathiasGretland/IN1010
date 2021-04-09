package uke12;

public class KaninOreTeller {
    public static void main(String[] args) {
        System.out.println(tellKaninOrer(0));
        System.out.println(tellKaninOrer(1));
        System.out.println(tellKaninOrer(2));
        System.out.println(tellKaninOrer(12));
        System.out.println(tellKaninOrer(234));
    }

    /*
    Oppgave 2a
    public static int tellKaninOrer(int antallKaniner){
        if (antallKaniner == 0){
            return 0;
        }
        return 2 + tellKaninOrer(antallKaniner-1);
    }
    */

    /*
    Oppgave 2b
     */
    public static int tellKaninOrer(int antallKaniner){
        if (antallKaniner == 0){
            return 0;
        }
        if (antallKaniner % 2 == 0){
            return 2 + tellKaninOrer(antallKaniner-1);
        }
        else {
            return 1 + tellKaninOrer(antallKaniner-1);
        }
    }
}
