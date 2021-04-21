package uke13;

import javax.swing.*;
import java.awt.*;

public class Snoemann {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Snoemann");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        panel.add(new SnoemannTegning());

        vindu.pack();
        vindu.setVisible(true);
    }
}

class SnoemannTegning extends JComponent{
    SnoemannTegning(){
        setPreferredSize(new Dimension(300, 600));
    }

    void tegnKule(Graphics2D g2, int centerX, int centerY, int radius){
        g2.setColor(Color.WHITE);
        g2.fillOval(centerX-radius, centerY-radius, 2*radius, 2*radius);
        g2.setColor(Color.BLACK);
        g2.drawOval(centerX-radius,centerY-radius, 2*radius,2*radius);
    }

    void tegnOye(Graphics2D g2, int centerX, int centerY, int radius){
        g2.setColor(Color.black);
        g2.fillOval(centerX-radius, centerY-radius, 2*radius, 2*radius);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Hodet
        tegnKule(g2,150,150,50);

        //Overkroppen
        tegnKule(g2, 150, 275, 75);

        //Underkroppen
        tegnKule(g2, 150,450,100);

        //Hatten
        g2.setColor(Color.RED);
        g2.fillRect(125,50,50,25);
        g2.fillRect(100,75,100,30);

        //Øyne
        tegnOye(g2,130,130,5);
        tegnOye(g2,170,130,5);

        //Nese
        Polygon triangle = new Polygon();
        triangle.addPoint(140,145);
        triangle.addPoint(170,165);
        triangle.addPoint(150,135);

        g2.setColor(Color.ORANGE);
        g2.fillPolygon(triangle);

        //Knapper
        tegnOye(g2, 150,275,5);
        tegnOye(g2, 150,310,5);
        tegnOye(g2, 150,240,5);

    }

}
