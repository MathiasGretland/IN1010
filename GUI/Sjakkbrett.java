package GUI;

import javax.swing.*;
import java.awt.*;

public class Sjakkbrett {
    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel brett = new JPanel();
        brett.setLayout(new GridLayout(8,8));
        for (int i = 8; i >= 1; i--){
            for (int y = 1; y <= 8; y++){
                JLabel tekst = new JLabel("");
                tekst.setPreferredSize(new Dimension(50,50));
                if ((i+y) % 2 == 0){
                    tekst.setBackground(Color.black);
                    tekst.setOpaque(true);
                } else {
                    tekst.setBackground(Color.white);
                    tekst.setOpaque(true);
                }

                brett.add(tekst);
            }



        }
        panel.add(brett);

        vindu.pack();
        vindu.setVisible(true);



    }
}
