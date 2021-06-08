package GUI;

import javax.swing.*;
import java.awt.*;

public class EnkelRutenett {

    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        Nett panel2 = new Nett();
        panel2.initGUI();
        for (int i = 1; i <= 9; i++){
            JLabel tall = new JLabel("" + i);
            tall.setPreferredSize(new Dimension(150,150));
            tall.setHorizontalAlignment(JLabel.CENTER);
            tall.setVerticalAlignment(JLabel.CENTER);
            tall.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel2.add(tall);
        }
        panel.add(panel2);


        vindu.pack();
        vindu.setVisible(true);
    }
}

class Nett extends JPanel{

    void initGUI(){
        setLayout(new GridLayout(3,3));
    }
}
