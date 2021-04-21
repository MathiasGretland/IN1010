package uke13;

import javax.swing.*;

public class Hallo {
    public static void main(String[] args) {
        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        String bruker = System.getProperty("user.name");
        JLabel hilsen = new JLabel("Hallo, " + bruker + "!");
        panel.add(hilsen);

        vindu.pack();
        vindu.setVisible(true);
    }
}
