package oblig7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Labyrinten brett = new Labyrinten();
        brett.initGUI();
        vindu.add(brett);




        vindu.pack();
        vindu.setVisible(true);
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
        setText(" ");

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