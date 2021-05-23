package repetisjon;

import uke3.Kvadrat;
import uke3.Sirkel;

public class Repetisjon <E> {
    public E element;

    public void settInn(E nyttElement){
        this.element = nyttElement;
    }

    public E taUt(){
        return this.element;
    }

    public static void main(String[] args) {
        Repetisjon<Sirkel> sirkelBeholder = new Repetisjon<>();
        sirkelBeholder.settInn(new Sirkel(12));
        //sirkelBeholder.settInn(new Kvadrat(12));
    }
}
