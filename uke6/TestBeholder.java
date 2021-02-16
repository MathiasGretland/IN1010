package uke6;

import uke3.Kvadrat;
import uke3.Sirkel;

public class TestBeholder {
    public static void main(String[] args) {
        Beholder<Sirkel> sirkelBeholder = new Beholder<>();
        sirkelBeholder.settInn(new Sirkel(10));
        //sirkelBeholder.settInn(new Kvadrat(10)); ikke lov! kan kun ta inn sirkel objekter
    }
}
