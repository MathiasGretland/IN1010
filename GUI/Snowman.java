package GUI;

import javax.swing.*;
import java.awt.*;

public class Snowman {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Snowman");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        vindu.add(panel);

        panel.add(new Board());


        vindu.pack();
        vindu.setVisible(true);
    }
}

class Board extends JComponent {
    Board(){
        setPreferredSize(new Dimension(600, 600));
    }

    void tegnKule(Graphics2D g2, int rad, int kolonne, int radius){
         g2.setColor(Color.WHITE);
         g2.fillOval(rad-radius, kolonne-radius, 2*radius, 2*radius);

    }

    void tegnRektangel(Graphics2D g2, int kolonne, int rad, int bredde, int hoyde){
        g2.setColor(Color.RED);
        g2.fillRect(kolonne, rad, bredde, hoyde);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //HEAD
        tegnKule(g2, 300,170,50);

        //Overkroppen
        tegnKule(g2, 300,300,90);

        //Underkroppen
        tegnKule(g2, 300,480,120);

        //Hatt
        tegnRektangel(g2,275,80,50,40);
        tegnRektangel(g2,260,120,80,5);

    }
}
