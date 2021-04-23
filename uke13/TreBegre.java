package uke13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TreBegre {
    static Beger[] begre = new Beger[1+3];
    static boolean ferdig = false;

    public static void main(String[] args) {
        JFrame vindu = new JFrame("3 begre");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        for (int i = 1; i <= 3; i++){
            begre[i] = new Beger(i);
            begre[i].initGUI();
            panel.add(begre[i]);
        }
        begre[new Random().nextInt(3)+1].harBall = true;

        vindu.pack();
        vindu.setVisible(true);
    }
}

class Beger extends JButton{
    int nr;
    boolean harBall = false;

    Beger (int nr){
        super("" + nr);
        this.nr = nr;
    }

    class Velger implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (TreBegre.ferdig) return;

            Beger b = (Beger)e.getSource();
            if (b.harBall){
                b.setForeground(Color.GREEN);
                b.setText("OK");
            }
            else {
                b.setForeground(Color.RED);
                b.setText("X");
            }
            TreBegre.ferdig = true;
        }
    }

    void initGUI(){
        addActionListener(new Velger());
    }
}
