package oblig7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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



class Labyrinten extends JPanel{
    Brettet brettet;
    Labyrint lab;
    File filnavn;


    Labyrinten (File filnavn, Labyrint lab) throws FileNotFoundException {
        this.filnavn = filnavn;
        this.lab = lab;
        brettet = new Brettet(this);
    }

    void initGUI (){
        //Her skal det skje mye
        brettet.initGUI();
        add(brettet);
    }

    File hentFil(){
        return filnavn;
    }

    Labyrint hentLabyrint(){
        return lab;
    }
}


class Brettet extends JPanel{
    Labyrinten labyrinten;
    Labyrint lab;
    Knapp[][] knapper;
    File fil;
    Scanner input;
    int rad;
    int kolonne;

    Brettet (Labyrinten labyrinten) throws FileNotFoundException {
        this.labyrinten = labyrinten;
        this.fil = labyrinten.hentFil();
        this.lab = labyrinten.hentLabyrint();
        input = new Scanner(fil);
        lagBrett();
    }

    void lagBrett(){
        String radOgKolonne = input.nextLine();
        String[] data = radOgKolonne.split(" ");
        rad = Integer.parseInt(data[0]);
        kolonne = Integer.parseInt(data[1]);
        knapper = new Knapp[rad][kolonne]; //Opprettelsen av ruteArray (Dette kunne også gjort øverst i programmet).
        int radInne = 0;
        int kolonneInne = 0;
        while (input.hasNext()) {
            String ruter = input.nextLine();
            for (int i = 0; i < ruter.length(); i++) {
                char tegn = ruter.charAt(i);
                if (tegn == '#') {
                    SortKnapp sortRute = new SortKnapp(radInne, kolonneInne);
                    knapper[radInne][kolonneInne] = sortRute;
                } else if (tegn == '.') {
                    if (radInne == 0 || radInne == (ruter.length() - 1) || kolonneInne == 0 || kolonneInne == (ruter.length() - 1)) {
                        AapningKnapp aapning = new AapningKnapp(radInne, kolonneInne);
                        knapper[radInne][kolonneInne] = aapning;
                    } else {
                        HvitKnapp hvitRute = new HvitKnapp(radInne, kolonneInne);
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

    void initGUI (){
        setLayout(new GridLayout(rad, kolonne));

        for (int i = 0;  i < knapper.length;  i++) {
            for (int y = 0; y <knapper[i].length; y++){
                knapper[i][y].initGUI();
                add(knapper[i][y]);
            }
        }
    }

    /*
    boolean reset(){
        boolean funnet = true;

    }

     */

    Knapp hentKnapp(int knappRad, int knappKolonne){
        return knapper[rad][kolonne];
    }

    Knapp[][] hentKnapper(){
        return knapper;
    }
}

class Knapp extends JButton{
    Brettet brett;
    int rad;
    int kolonne;


    Knapp (int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
    }

    void initGUI (){
    }
}

class SortKnapp extends Knapp{

    SortKnapp(int rad, int kolonne) {
        super(rad, kolonne);
    }

    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 15));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.BLACK);


        Knapp denneKnappen = this;
        class SortKnappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                String radTekst = String.valueOf(rad);
                String kolonneTekst = String.valueOf(kolonne);
                setText("(" + radTekst + "," + kolonneTekst+ ")");
            }
        }
        addActionListener(new SortKnappvelger());
    }
}

class HvitKnapp extends Knapp{

    HvitKnapp(int rad, int kolonne) {
        super(rad, kolonne);
    }

    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 15));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);


        Knapp denneKnappen = this;
        class HvitKnappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                String radTekst = String.valueOf(rad);
                String kolonneTekst = String.valueOf(kolonne);
                setText("(" + radTekst + "," + kolonneTekst+ ")");
                brett.lab.finnUtveiFra(denneKnappen.rad, denneKnappen.kolonne);
            }
        }
        addActionListener(new HvitKnappvelger());
    }
}

class AapningKnapp extends Knapp{

    AapningKnapp(int rad, int kolonne) {
        super(rad, kolonne);
    }

    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 15));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);


        Knapp denneKnappen = this;
        class AapningKnappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                String radTekst = String.valueOf(rad);
                String kolonneTekst = String.valueOf(kolonne);
                setText("(" + radTekst + "," + kolonneTekst+ ")");
            }
        }
        addActionListener(new AapningKnappvelger());
    }
}
