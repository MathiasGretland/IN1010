package uke13;

import javax.swing.*;
import java.awt.*;

public class Sjakkbrett {
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Sjakkbrett");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        panel.setLayout(new GridLayout(8,8));
        for (int i = 8; i >= 1; i--){
            for (int y = 1; y <= 8; y++){
                Rute r;
                if ((i+y)%2 == 1){
                    r = new HvitRute();
                } else {
                    r = new SortRute();
                }
                r.initGUI();
                panel.add(r);
            }
        }

        vindu.pack();
        vindu.setVisible(true);
    }
}
abstract class Rute extends JLabel{
    void initGUI(){
        setPreferredSize(new Dimension(150,150));
        setOpaque(true);
    }
}

class HvitRute extends Rute{
    @Override
    void initGUI() {
        super.initGUI();
        setBackground(Color.WHITE);
    }
}

class SortRute extends Rute{
    @Override
    void initGUI(){
        super.initGUI();
        setBackground(Color.BLACK);
    }
}
