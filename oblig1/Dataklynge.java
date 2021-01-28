package oblig1;

import uke3.Sang;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Dataklynge {
    //Private variabler som tilsier hvor mange noder man kan ha i et rack, samt oppretter en ArrayList med rackobjekter
    private int noderPerRack;
    private ArrayList<Rack> hoved = new ArrayList<>();
    private String filnavn;
    private ArrayList<Integer> antallNoder = new ArrayList<>();
    private ArrayList<Integer> minne = new ArrayList<>();
    private ArrayList<Integer> antallProsessorer = new ArrayList<>();

    //Konstruktør
    //Angir hvor mange noder racket kan inneholde
    public Dataklynge(int noderPerRack){
        this.noderPerRack = noderPerRack;
    }

    //Konstruktør
    //Henter inn fra fil, samt kjører metoden lesDataFraFil()
    public Dataklynge(String filnavn){
        this.filnavn = filnavn;
        lesDataFraFil(filnavn);
    }

    //Leser inn data fra fil
    public void lesDataFraFil(String filnavn){
        File fil = new File(filnavn);
        Scanner in;
        try{
            in = new Scanner(fil);
        }catch (FileNotFoundException exception){
            System.out.println("Fant ikke filen");
            in = new Scanner("");
        }
        //Kjører gjennom hver linje av filen
        while (in.hasNextLine()){
            String linje = in.nextLine();
            String [] alleData = linje.split(" ");
            //Hvis linjen kun har et heltall, så vil det være antall noderPerRack
            if (alleData.length == 1){
                noderPerRack = Integer.parseInt(alleData[0]);
            } else {
                //Hvis linjen har mer enn et heltall, vil det være antall noder, minne-kapasitet og antall prosessorer.
                antallNoder.add(Integer.parseInt(alleData[0]));
                minne.add(Integer.parseInt(alleData[1]));
                antallProsessorer.add(Integer.parseInt(alleData[2]));
            }
        }
        //Kaller på settInnNodeFraFil()
        settInnNodeFraFil();
    }

    //Hjelpemetode som bruker metoden settInnNode ved bruk av tall fra fil.
    public void settInnNodeFraFil(){
        for (int i = 0; i < antallNoder.size(); i++){
            for (int j = 0; j < antallNoder.get(i); j++){
                settInnNode(new Node(minne.get(i), antallProsessorer.get(i)));
            }
        }

    }

    //Setter noder inn i et rack med ledig plass, hvis det ikke er ledig plass lages det et nytt rack
    public void settInnNode(Node node){
        if (hoved.size() != 0){
            Rack rack = hoved.get(hoved.size()-1);
            //Hvis det er ledig plass for noden legges den til
            if (rack.ledigPlass()){
                rack.leggTilNode(node);
            }
            //Hvis det ikke er ledig plass for noden i racket, opprettes det en ny rack
            else{
                Rack racks = new Rack(noderPerRack);
                racks.leggTilNode(node);
                hoved.add(racks);
            }

        }
        //Hvis det ikke finnes noen racks i dataklyngen, vil det opprettes et nytt et
        else {
            Rack rack = new Rack(noderPerRack);
            rack.leggTilNode(node);
            hoved.add(rack);
        }
    }

    //Beregner og returnerer totalt antall prosessorer i hele dataklyngen
    public int antProsessorer(){
        int antPros = 0;

        // bruker .get(i) for å kjøre .antProsessorer på alle objektene i hoved
        for (int i = 0; i < hoved.size(); i++){
            antPros += hoved.get(i).antProsessorer();
        }
        return antPros;
    }

    //Beregner og returnerer antallet noder i dataklyngen med minne over en gitt mengde som man gis i paramteren
    public int noderMedNokMinne(int paakrevdMinne){
        int antNoderMedNokMinne = 0;

        // bruker .get(i) for å kjøre .noderMedNokMinne på alle objektene i hoved
        for (int i = 0; i < hoved.size(); i++) {
            antNoderMedNokMinne += hoved.get(i).noderMedNokMinne(paakrevdMinne);
        }

        return antNoderMedNokMinne;
    }

    //Returnerer antall racks i dataklyngen
    public int antRacks(){
        return hoved.size();
    }
}
