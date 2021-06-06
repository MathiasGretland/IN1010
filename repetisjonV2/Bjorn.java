package repetisjonV2;

public class Bjorn implements Rovdyr{

    public static void main(String[] args) {
        Bjorn bjorn = new Bjorn();
        Elg elg = new Elg();
        Sau sau = new Sau();
        Ulv ulv = new Ulv();
        Planteetere[] planteeteres = new Planteetere[10];
        Rovdyr[] rovdyrs = new Rovdyr[10];
        rovdyrs[0] = bjorn;
        rovdyrs[1] = ulv;
        planteeteres[0] = elg;
        planteeteres[1] = sau;
        System.out.println(planteeteres[1]);
    }

    @Override
    public void gaaPaaJakt() {

    }
}
