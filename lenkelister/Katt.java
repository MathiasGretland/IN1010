package lenkelister;

import java.util.ArrayList;

public class Katt implements Comparable<Katt>{
    String navn;
    int alder;

    public Katt(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public String toString(){
        String strenge = "Navn: " + navn + "\nAlder: " + alder;
        return strenge;
    }

    @Override
    public int compareTo(Katt nyPus) {
        if (alder < nyPus.alder){
            return -1;
        }
        else if (alder > nyPus.alder){
            return 1;
        }
        else {
            return 0;
        }
    }


    public static void main(String[] args) {
        ArrayList<Katt> katteListe = new ArrayList<>();

        Katt oleksander = new Katt("Oleksander", 3);
        Katt albert = new Katt("Albert",5);
        Katt jeff = new Katt("Jeff",8);
        Katt ida = new Katt("Ida",5);
        Katt steph = new Katt("Steph",2);
        Katt curry = new Katt("Curry",7);

        katteListe.add(oleksander);
        katteListe.add(albert);
        katteListe.add(jeff);
        katteListe.add(ida);
        katteListe.add(steph);
        katteListe.add(curry);

        Katt storst = katteListe.get(0);

        for (Katt e : katteListe){
            if (storst.compareTo(e) < 0){
                storst = e;
            }
        }

        System.out.println(storst);
    }
}
