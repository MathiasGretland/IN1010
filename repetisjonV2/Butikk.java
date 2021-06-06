package repetisjonV2;

import java.util.Iterator;

public class Butikk implements Iterable<Person>{
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

        for (Person p : butikken){
            System.out.println(p);
        }

    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonITterator();
    }

    private class PersonITterator implements Iterator<Person>{
        private Person denne;


        PersonITterator(){
            denne = start;
        }

        @Override
        public boolean hasNext() {
            if (denne != null){
                return true;
            }
            return false;
        }

        @Override
        public Person next() {
            Person midl = denne;
            denne = denne.neste;
            return midl;
        }
    }
}
