package lenkelister;

import java.util.ArrayList;

public class SortertArrayList <T extends Comparable<T>>{
    ArrayList<T> liste = new ArrayList<>();


    public void settInn(T data){
        for (int i = 0; i < liste.size(); i++){
            if (liste.get(i).compareTo(data) > 0){
                liste.add(i,data);
                return;
            }
        }
        liste.add(data);
    }

    public T hentUtForste(){
        if (liste == null){
            return null;
        }
        return liste.remove(0);
    }

    public static void main(String[] args) {
        SortertArrayList<Katt> katter = new SortertArrayList<>();
        katter.settInn(new Katt("a", 5));
        katter.settInn(new Katt("b", 3));
        katter.settInn(new Katt("c", 1));
        katter.settInn(new Katt("d", 10));
        for (int i = 0; i < 4; i++) {
            System.out.println(katter.hentUtForste());
        }
    }
}

