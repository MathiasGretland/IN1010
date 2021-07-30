package utfordringer;

public class Baathus {
    Baat[] baathus;
    int baathusStorrelse;
    int teller = 0;

    Baathus(int baathusStorrelse){
        this.baathusStorrelse = baathusStorrelse;
        baathus = new Baat[baathusStorrelse];
    }

    public void settInn(Baat b){
        if (teller != baathusStorrelse){
            baathus[teller] = b;
            teller++;
        }else {
            System.out.println("Ikke plass til flere");
        }
    }

    public void skrivUtBaater(){
        for (Baat b : baathus){
            System.out.println(b.hentInfo());
        }
    }

    public int tall(int tall){
        return tall;
    }
}
