package uke13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomKnapp extends JButton {
    private int teller = 0;

    public CustomKnapp(String tall){
        super(tall);
        this.setText(String.valueOf(teller));
        addActionListener(new CustomRespons());

    }

    class CustomRespons implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           setText(String.valueOf(++teller));
        }
    }
}
