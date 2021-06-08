package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreBegre {
    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel nett = new JPanel();
        nett.setLayout(new GridLayout(1,3));
        int random = (int)Math.floor(Math.random()*(3-1+1)+1);
        for (int i = 1; i < 4; i++){
            if (i == random){
                RiktigKnapp swag = new RiktigKnapp();
                swag.initGUI();
                nett.add(swag);
            }else {
                FeilKnapp swag = new FeilKnapp();
                swag.initGUI();
                nett.add(swag);
            }
        }
        panel.add(nett);
        vindu.pack();
        vindu.setVisible(true);

    }
}

class RiktigKnapp extends JButton{

    void initGUI(){
        setPreferredSize(new Dimension(200,200));

        class RiktigKnappVelger implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                setText("RIKTIG POG!");
            }
        }
        addActionListener(new RiktigKnappVelger());
    }

}

class FeilKnapp extends JButton{

    void initGUI(){
        setPreferredSize(new Dimension(200,200));

        class FeilKnappVelger implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                setText("WRONG DUMB DUMB!");
            }
        }
        addActionListener(new FeilKnappVelger());
    }

}