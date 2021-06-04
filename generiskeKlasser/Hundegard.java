package generiskeKlasser;

public class Hundegard {
    private Hund [] hundene;
    public int antall = 0;

    public Hundegard(int antallHunder){
        hundene = new Hund[antallHunder];
    }

    public void settInn(Hund h){
        if (antall > hundene.length){
            System.out.println("Det er fullt!");
            return;
        }
        hundene[antall] = h;
        antall++;
    }

    public Hund taUt(){
        if (storrelse() == 0){
            System.out.println("Det er ingen hunder å ta");
            return null;
        }
        antall--;
        return hundene[antall];
    }

    public int storrelse(){
        int teller = 0;
        for (Hund h : hundene){
            if (h != null){
                teller++;
            }
        }
        return teller;
    }

}
