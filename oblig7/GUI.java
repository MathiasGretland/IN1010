package oblig7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Labyrinten brett = new Labyrinten();
        Knapp[][] ruter = brett.hentRuteArray();
        brett.initGUI();
        vindu.add(brett);


        Grafisk swag = new Grafisk(ruter);// DENNE ER DOODOO OG SKAL IKKE VÆRE MED, KUN BRUKT TIL ILLUSTRASJON
        brett.add(swag);


        vindu.pack();
        vindu.setVisible(true);
    }
}



class Labyrinten extends JPanel{
    static Knapp[][] ruteArray;
    static int rad;
    static int kolonne;
    //JBUTTONS
    //JLABELS for tekst
    Brettet brettet;

    Labyrinten (){
        brettet = new Brettet(this);
    }

    void initGUI (){
        //Her skal det skje mye
        brettet.initGUI();
        add(brettet);
    }

    static Knapp[][] lesFil(){
        ArrayList<Knapp> res = new ArrayList<>();
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION)
            System.exit(1);
        File f = velger.getSelectedFile();
        Scanner input = null;
        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        String radOgKolonne = input.nextLine();
        String[] data = radOgKolonne.split(" ");
        rad = Integer.parseInt(data[0]);
        kolonne = Integer.parseInt(data[1]);
        ruteArray = new Knapp[rad][kolonne]; //Opprettelsen av ruteArray (Dette kunne også gjort øverst i programmet).
        int radInne = 0;
        int kolonneInne = 0;
        while (input.hasNext()) {
            String ruter = input.nextLine();
            for (int i = 0; i < ruter.length(); i++) {
                char tegn = ruter.charAt(i);
                if (tegn == '#') {
                    SortKnapp sortRute = new SortKnapp(radInne, kolonneInne);
                    ruteArray[radInne][kolonneInne] = sortRute;
                } else if (tegn == '.') {
                    if (radInne == 0 || radInne == (ruter.length() - 1) || kolonneInne == 0 || kolonneInne == (ruter.length() - 1)) {
                        Knapp aapning = new Knapp(radInne, kolonneInne);
                        ruteArray[radInne][kolonneInne] = aapning;
                    } else {
                        Knapp hvitRute = new Knapp(radInne, kolonneInne);
                        ruteArray[radInne][kolonneInne] = hvitRute;
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
        return ruteArray;
    }

    public int hentRad(){
        return rad;
    }

    public int hentKolonne(){
        return kolonne;
    }

    public Knapp[][] hentRuteArray(){
        return ruteArray;
    }

}


class Brettet extends JPanel{
    Labyrinten labyrinten;
    Knapp[][] knapper = labyrinten.lesFil();

    Brettet (Labyrinten l){
        labyrinten = l;
    }

    void initGUI (){
        setLayout(new GridLayout(labyrinten.hentRad(), labyrinten.hentKolonne()));

        for (int i = 0;  i < knapper.length;  i++) {
            for (int y = 0; y <knapper[i].length; y++){
                knapper[i][y].initGUI();
                add(knapper[i][y]);
            }
        }
    }
}

class Knapp extends JButton{
    int rad;
    int kolonne;

    Knapp (int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
    }

    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 50));
        setPreferredSize(new Dimension(60, 60));
        setBackground(Color.WHITE);


        Knapp denneKnappen = this;
        class Knappvelger implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e) {
                setText(":(");
            }
        }
        addActionListener(new Knappvelger());
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

//DENNE ER OGSÅ DOODOO OG MÅ FJERNES/FIKSES
class Grafisk extends JComponent {
    Knapp[][] elementer;

    Grafisk (Knapp[][] elem) {
        elementer = elem;
    }
}