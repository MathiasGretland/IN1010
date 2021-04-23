package uke13;

import javax.swing.*;
import java.awt.*;

public class GUITemplate {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("GUITemplate");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);


        //panel.setLayout(new GridLayout(2,4));

        int rows = 2;
        int columns = 4;
        LayoutManager grid = new GridLayout(rows,columns);
        panel.setLayout(grid);

        JLabel tekst = new JLabel("Dette er en standardtekst", SwingConstants.CENTER);
        //tekst.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tekst);

        CustomKnapp tellerKnapp = new CustomKnapp("SUP");
        panel.add(tellerKnapp);

        /*
        JPanel ekstraPanel = new JPanel();
        GridLayout nyttLayout = new GridLayout(2,2);
        ekstraPanel.setLayout(nyttLayout);

        JLabel tekst6 = new JLabel("I ekstra");
        JLabel tekst7 = new JLabel("panelet");

        ekstraPanel.add(tekst6);
        ekstraPanel.add(tekst7);



        JButton knapp = new JButton("SUP");
        ekstraPanel.add(knapp);

        panel.add(ekstraPanel);
         */

        vindu.pack();
        vindu.setVisible(true);
    }
}
