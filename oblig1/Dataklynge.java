package oblig1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Dataklynge {
    private int noderPerRack;
    private ArrayList<Rack> hoved = new ArrayList<>();

    public Dataklynge(int noderPerRack){
        this.noderPerRack = noderPerRack;
    }

    public void settInnNode(Node node){
        for (Rack rack : hoved) {
            if (rack.ledigPlass()){
                rack.add(node);
            }
            else{
                Rack racks = new Rack(noderPerRack);
                racks.add(node);
                hoved.add(racks);
            }
        }
    }

    public int antProsessorer(){
        int antPros = 0;

        // bruker .get(i) for å kjøre .antProsessorer på alle objektene i r
        for (int i = 0; i < hoved.size(); i++){
            antPros += hoved.get(i).antProsessorer();
        }
        return antPros;
    }


    public int noderMedNokMinne(int paakrevdMinne){
        int antNoderMedNokMinne = 0;

        // bruker .get(i) for å kjøre .noderMedNokMinne på alle objektene i r
        for (int i = 0; i < hoved.size(); i++) {
            antNoderMedNokMinne += hoved.get(i).noderMedNokMinne(paakrevdMinne);
        }

        return antNoderMedNokMinne;
    }

    public int antRacks(){
        return hoved.size();
    }
}
