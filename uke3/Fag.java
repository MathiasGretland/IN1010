package uke3;

import java.util.HashMap;

public class Fag {
    private String fagkode;
    private HashMap<String, Student> mineStudenter = new HashMap<String, Student>();

    public Fag(String fagkode){
        this.fagkode = fagkode;
    }

    public String toString(){
        return this.fagkode;
    }

    public void leggTilStudent(Student student){
        if (finnesStudent(student)){
            System.out.println(student.toString() + " tar allerede " + fagkode);
        }
        mineStudenter.put(student.toString(), student);
    }

    public boolean finnesStudent(Student student){
        if (mineStudenter.containsValue(student)){
            return true;
        }return false;
    }

    public void fjernMegFraStudenter(){
        for (Student studentSomTarFaget : mineStudenter.values()){
            studentSomTarFaget.fjernFagFraStudent(this);
        }
    }

    public HashMap<String, Student> listeAvStudenter(){
        return mineStudenter;
    }

    public void skrivMineStudenter(){
        for (Student student : mineStudenter.values()){
            System.out.println(student.toString());
        }
    }

    public void fjernStudent(Student student){
        if (finnesStudent(student)) {
            mineStudenter.remove(student);
        } else{
            System.out.println(student.toString() + " har ikke meldt seg opp i " + fagkode);
        }
    }

    public int antStudenter(){
        return mineStudenter.size();
    }
}


