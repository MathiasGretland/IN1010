package proveeksamen;

public class Sykehus {
    Avdeling akkuten;
    Avdeling sengepost;

    public void skrivInnPasient(Pasient p, Avdeling a){
        a.pasienter.settInnPasient(p);
    }

    public void overforPasient(Pasient p, Avdeling fra, Avdeling til){
        if (fra.hentUt(p) != null){
            til.settInn(p);
        }
    }

    public void skrivUtPasient(Pasient p, Avdeling a){
        a.hentUt(p);
    }

    public static boolean iFaresonenMann(){
        return true;
    }

    public static boolean iFaresonenKvinne(){
        return true;
    }


    public static void main(String[] args) {
        Sykehus sykehuset = new Sykehus();
        sykehuset.akkuten = new Akkutten();
        sykehuset.sengepost = new Sengepost(100);

        Pasient stian = new MannligPasient("Stian", "420", 3);
        Pasient carl = new MannligPasient("Carl", "69", 2);
        sykehuset.skrivUtPasient(stian, sykehuset.akkuten);
        sykehuset.skrivUtPasient(carl, sykehuset.akkuten);

        sykehuset.overforPasient(stian, sykehuset.akkuten, sykehuset.sengepost);
        sykehuset.skrivInnPasient(carl, sykehuset.akkuten);
    }
}
