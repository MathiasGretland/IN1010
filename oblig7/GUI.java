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
        brett.initGUI();
        vindu.add(brett);

        ArrayList<Knapp> ruter = new ArrayList<>();
        Grafisk swag = new Grafisk(ruter);// DENNE ER DOODOO OG SKAL IKKE VÆRE MED, KUN BRUKT TIL ILLUSTRASJON
        brett.add(swag);

        vindu.pack();
        vindu.setVisible(true);
    }

    static ArrayList<Knapp> lesFil(){
        ArrayList<Knapp> res = new ArrayList<>();
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION)
            System.exit(1);
        File f = velger.getSelectedFile();
        Scanner leser = null;
        try {
            leser = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        return res;
    }
}
class Labyrinten extends JPanel{
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
}


class Brettet extends JPanel{
    Labyrinten labyrinten;
    Knapp knapp[] = new Knapp[144+1];



    Brettet (Labyrinten l){
        labyrinten = l;
        for (int i = 1; i <= 144; i++){
            knapp[i] = new Knapp(this);
        }
    }

    void initGUI (){
        setLayout(new GridLayout(12, 12));

        for (int i = 1;  i <= 144;  i++) {
            knapp[i].initGUI();
            add(knapp[i]);
        }
    }
}

class Knapp extends JButton{
    Brettet brettet;

    Knapp (Brettet b){
        brettet = b;
    }

    void initGUI (){
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 50));
        setPreferredSize(new Dimension(80, 80));
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

//DENNE ER OGSÅ DOODOO OG MÅ FJERNES/FIKSES
class Grafisk extends JComponent {
    ArrayList<Knapp> elementer;

    Grafisk (ArrayList<Knapp> elem) {
        elementer = elem;
        setPreferredSize(new Dimension(10, 10));
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Knapp e: elementer)
            e.setBackground(Color.WHITE);
    }
}