package uke7.Time;
public class Hovedprogram {
    public static void main(String[] args) {
        Node<String> forste = new Node<String>("Hei");
        forste.settNeste(new Node<String>("paa"));
        forste.hentNeste().settNeste(new Node<String>("deg"));

        System.out.println(forste);

        Node<String> forste2 = new Node<String>(",");
        forste2.settNeste(new Node<String>("hvordan"));
        forste2.hentNeste().settNeste(new Node<String>("gaar"));
        forste2.hentNeste().hentNeste().settNeste(new Node<String>("det?"));

        System.out.println(forste2);

        //forste.hentNeste().hentNeste().settNeste(forste2);

        Node<String> tmp = forste;
        while(tmp.hentNeste() != null){
            tmp = tmp.hentNeste();
        }
        tmp.settNeste(forste2);

        System.out.println(forste);

        Operasjonsliste<String> liste = new Operasjonsliste<>();
        liste.settInnForst("deg");
        liste.settInnForst("paa");
        liste.settInnForst("Hei");

        System.out.println(liste);

        Operasjonsliste<String> liste2 = new Operasjonsliste<>();
        liste2.settInnForst("det?");
        liste2.settInnForst("gaar");
        liste2.settInnForst("hvordan");
        liste2.settInnForst(",");

        liste.leggTilOperasjonsliste(liste2);
        System.out.println("\nListe etter at liste 2 er lagt til: ");
        System.out.println(liste);

        liste.settInnEtterElement("det?", "?");
        System.out.println("\nListe etter at du er satt inn  ? etter deg?: ");
        System.out.println(liste);

        liste.settInnEtterElement("deg", "du");
        System.out.println("\nListe etter at du er satt inn du etter deg ");
        System.out.println(liste);

        liste.fjernAnnenHver();
        System.out.println("\nEtter fjern annen hver:");
        System.out.println(liste);

    }

}