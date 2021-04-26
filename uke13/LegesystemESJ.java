package uke13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LegesystemESJ {

    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JButton printKnapp = new JButton();
        printKnapp.setText("LEGESYSTEM");
        printKnapp.addActionListener(new KlikketPaa());
        panel.add(printKnapp);



        vindu.pack();
        vindu.setVisible(true);
    }
}

class KlikketPaa implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("ÆSJ");
    }
}