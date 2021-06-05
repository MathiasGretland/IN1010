package repetisjonV2;

public class Butikk {
    Person start;

    public void entreButikk(Person p){
        if (start == null){
            start = p;
        } else {
            Person forrigeNeste = start.neste;
            start.neste = p;
            p.neste = forrigeNeste;
        }
    }

    public void kassa(){
        Person iter = start;
        while (iter != null){
            System.out.println(iter);
            iter = iter.neste;
        }
    }

    public static void main(String[] args) {
        Butikk butikken = new Butikk();
        butikken.entreButikk(new Person("Aleksander", "Kebab"));
        butikken.entreButikk(new Person("Jakob", "Kebab"));
        butikken.entreButikk(new Person("Magnus", "Kebab"));
        butikken.entreButikk(new Person("DOG", "Kebab"));
        butikken.entreButikk(new Person("Slavex", "Kebab"));
        butikken.kassa();

    }
}
