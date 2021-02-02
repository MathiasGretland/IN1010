package uke3;

import java.util.HashMap;

public class Student {
    private String navn;
    private HashMap<String, Fag> mineFag = new HashMap<String, Fag>();

    public Student(String navn){
        this.navn = navn;
    }

    public void leggTilFag(Fag fag){
        if (tarFag(fag)){
            System.out.println(navn + " tar allerede " + fag.toString());
        }
        mineFag.put(fag.toString(), fag);
    }

    public String toString(){
        return this.navn;
    }

    public boolean tarFag(Fag fag){
        if (mineFag.containsValue(fag)){
            return true;
        }return false;
    }

    public void skrivUtMineFag(){
        for (Fag fag : mineFag.values()){
            System.out.println(fag.toString());
        }
    }

    public void meldMegAvAlleFag(){
        for (Fag fagJegTar : mineFag.values()){
            fagJegTar.finnesStudent(this);
        }
    }

    public void fjernFagFraStudent(Fag fag){
        if (!tarFag(fag)){
            System.out.println(navn + " har aldri vært oppmeldt i " + fag.toString());
        }
        mineFag.remove(fag);
    }

    public int antFag(){
        return mineFag.size();
    }



}
