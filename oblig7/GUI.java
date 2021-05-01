package oblig7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Oppretter klassen GUI
 */
public class GUI {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION){
            System.exit(1);
        }
        File file = velger.getSelectedFile();
        Labyrint lab = new Labyrint(file);
        Labyrinten brett = new Labyrinten(file, lab);
        brett.initGUI();
        vindu.add(brett);
        vindu.pack();
        vindu.setVisible(true);
    }
}

/**
 * Oppretter klassen Labyrinten som er en subklasse av klassen JPanel
 */
class Labyrinten extends JPanel{
    Brettet brettet;
    Labyrint lab;
    File filnavn;
    JButton avslutt;
    JLabel info;
    JButton reset;

    /**
     * Konstruktøren obretter et brett, inne i konstruktøren.
     * @param filnavn Tar inn en File
     * @param lab Tar inn en Labyrint
     * @throws FileNotFoundException Sender den videre
     */
    Labyrinten (File filnavn, Labyrint lab) throws FileNotFoundException {
        this.filnavn = filnavn;
        this.lab = lab;
        brettet = new Brettet(this);
    }

    /**
     * Metoden initGUI oppretter får innholdet til brettet på vinduet (vindu som opprettes i hovedprogrammet) samt. noen buttons og tekst.
     */
    void initGUI (){
        //Her skal det skje mye
        brettet.initGUI();
        add(brettet);

        info = new JLabel("Velg en hvit rute!");
        add(info);

        reset = new JButton("NULLSTILL");
        class Reset implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                brettet.reset();
            }
        }
        reset.addActionListener(new Reset());
        add(reset);

        avslutt = new JButton("EXIT");
        class Stopp implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                System.exit(0);
            }
        }
        avslutt.addActionListener(new Stopp());
        add(avslutt);

    }

    File hentFil(){
        return filnavn;
    }

    Labyrint hentLabyrint(){
        return lab;
    }
}

/**
 * Oppretter klassen Brettet som er en subklasse av klassen JPanel
 */
class Brettet extends JPanel{
    Labyrinten labyrinten;
    Labyrint lab;
    Knapp[][] knapper;
    File fil;
    Scanner input;
    int rad;
    int kolonne;

    /**
     * Konstruktøren til Brettet lager brettet basert på hva den leser inn fra filen som brukeren velger.
     * @param labyrinten Tar inn en Labyrinten
     * @throws FileNotFoundException Sender den videre
     */
    Brettet (Labyrinten labyrinten) throws FileNotFoundException {
        this.labyrinten = labyrinten;
        this.fil = labyrinten.hentFil();
        this.lab = labyrinten.hentLabyrint();
        input = new Scanner(fil);
        lagBrett();
    }

    /**
     * Metoden lagBrett er en kopi av lesInn fra Labyrint klassen, men den er gjort om slik at den passer programmet.
     */
    void lagBrett(){
        String radOgKolonne = input.nextLine();
        String[] data = radOgKolonne.split(" ");
        rad = Integer.parseInt(data[0]);
        kolonne = Integer.parseInt(data[1]);
        knapper = new Knapp[rad][kolonne];
        int radInne = 0;
        int kolonneInne = 0;
        while (input.hasNext()) {
            String ruter = input.nextLine();
            for (int i = 0; i < ruter.length(); i++) {
                char tegn = ruter.charAt(i);
                if (tegn == '#') {
                    SortKnapp sortRute = new SortKnapp(radInne, kolonneInne, this);
                    knapper[radInne][kolonneInne] = sortRute;
                } else if (tegn == '.') {
                    if (radInne == 0 || radInne == (ruter.length() - 1) || kolonneInne == 0 || kolonneInne == (ruter.length() - 1)) {
                        AapningKnapp aapning = new AapningKnapp(radInne, kolonneInne, this);
                        knapper[radInne][kolonneInne] = aapning;
                    } else {
                        HvitKnapp hvitRute = new HvitKnapp(radInne, kolonneInne, this);
                        knapper[radInne][kolonneInne] = hvitRute;
                    }
                }
                //Går videre til neste kolonne
                kolonneInne++;
            }
            // Nullstiller den før forloopen starter på en ny
            kolonneInne = 0;
            // Nullstiller den slik at vi går til neste rad
            radInne++;
        }
        input.close();
    }

    /**
     * Metoden initGUI setter dimensjonene samt legger til knappene
     */
    void initGUI (){
        setLayout(new GridLayout(rad, kolonne));

        for (int i = 0;  i < knapper.length;  i++) {
            for (int y = 0; y <knapper[i].length; y++){
                knapper[i][y].initGUI();
                add(knapper[i][y]);
            }
        }
    }

    /**
     * Metdoen reset() setter brettet tilbake til slik det så ut, etter at det først ble opprettet.
     */
    void reset(){
        for (Knapp[] k: knapper){
            for (Knapp r : k){
                if (r instanceof HvitKnapp){
                    r.setBackground(Color.WHITE);
                }
                else if (r instanceof AapningKnapp){
                    r.setBackground(Color.WHITE);
                }
            }
        }
        labyrinten.info.setText("Velg en hvit rute!");
    }
}

/**
 * Oppretter klassen Knapp som er en subklasse av klassen JButton
 */
class Knapp extends JButton{
    Brettet brett;
    int rad;
    int kolonne;


    Knapp (int rad, int kolonne, Brettet brett){
        this.rad = rad;
        this.kolonne = kolonne;
        this.brett = brett;
    }

    /**
     * Metoden initGUI er der slik at knappene får, riktig størrelse, farge og utfører ActionListener
     */
    void initGUI (){
    }
}

/**
 * Oppretter klassen SortKnapp som er en subklasse av klassen Knapp
 */
class SortKnapp extends Knapp{

    SortKnapp(int rad, int kolonne, Brettet brett) {
        super(rad, kolonne, brett);
    }

    /**
     * Metoden initGUI er der slik at knappene får, riktig størrelse, farge og utfører ActionListener
     */
    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.BLACK);
    }
}

/**
 * Oppretter klassen HvitKnapp som er en subklasse av klassen Knapp
 */
class HvitKnapp extends Knapp{
    int antallUtveier;
    HvitKnapp(int rad, int kolonne, Brettet brett) {
        super(rad, kolonne, brett);
    }

    /**
     * Metoden initGUI er der slik at knappene får, riktig størrelse, farge og utfører ActionListener
     */
    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);

        class HvitKnappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                /**
                 * Finner alle utveiene og skriver ut det, samt. Gjør stien fra den HviteRuten til utveien tydelig med å gjøre rutene grønne
                 */
                ArrayList<ArrayList<Tuppel>> utveier = brett.lab.finnUtveiFra(rad,kolonne);
                antallUtveier = utveier.size();
                ArrayList<Tuppel> kjappeste = utveier.get(0);
                for (Tuppel p : kjappeste){
                    int tuppelRad = p.rad;
                    int tuppelKolonne = p.kolonne;
                    for (Knapp[] k : brett.knapper){
                        for (Knapp r : k){
                            if (r.rad == tuppelRad && r.kolonne == tuppelKolonne){
                                r.setBackground(Color.GREEN);
                            }
                        }
                    }
                }
                brett.labyrinten.info.setText("Labyrinten fant: " + antallUtveier + " utveier. " + "Viser den korteste utveien.");
            }
        }
        addActionListener(new HvitKnappvelger());
    }
}

/**
 * Oppretter klassen AapningKnapp som er en subklasse av klassen Knapp
 */
class AapningKnapp extends Knapp{

    AapningKnapp(int rad, int kolonne, Brettet brett) {
        super(rad, kolonne, brett);
    }

    /**
     * Metoden initGUI er der slik at knappene får, riktig størrelse, farge og utfører ActionListener
     */
    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);

        class AapningKnappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                brett.labyrinten.info.setText("Dette er en åpning! Trykk på en annen hvit rute!");
            }
        }
        addActionListener(new AapningKnappvelger());
    }
}
