package uke12.regnetime;

public class Hovedprogram {
    public static void main(String[] args) {
        Menneske albert = new Menneske("Albert", 25);
        Menneske bendik = new Menneske("Bendik", 12);
        Menneske anne = new Menneske("Anne", 52);
        Menneske gunnhild = new Menneske("Gunnhild", 42);
        Menneske kristian = new Menneske("Kristian", 43);
        Menneske bjart = new Menneske("Bjart", 84);
        Menneske bengt = new Menneske("Bengt", 47);
        Menneske rannveig = new Menneske("Rannveig", 48);

        bendik.settFar(bengt);
        bendik.settMor(rannveig);
        System.out.println(anne.finnEldstePersonIForgrening());
        System.out.println(bendik.finnEldstePersonIForgrening());
        System.out.println();
        System.out.println(bendik.familieTre());
    }
}
