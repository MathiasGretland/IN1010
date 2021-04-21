package uke13.lesGeometri;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class LesGeometri {
    public static void main (String[] arg) {
        JFrame vindu = new JFrame("Geometriske figurer");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        ArrayList<Geometrisk> elementer = lesFil();
        Grafisk tegning = new Grafisk(elementer);
        panel.add(tegning);

        vindu.pack();
        vindu.setVisible(true);
    }

    static ArrayList<Geometrisk> lesFil () {
        //Dette fram til neste // er alt man trenger for å lese inn fra fil
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION)
            System.exit(1);
        File f = velger.getSelectedFile();
        Scanner leser = null;
        try {
            leser = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        //


        ArrayList<Geometrisk> res = new ArrayList<>();
        String type = "";
        while (leser.hasNextLine()) {
            String linje = leser.nextLine();
            if (linje.equals("# Rectangles") || linje.equals("# Circles") ||
                    linje.equals("# Polygons"))
            {
                type = linje;
            } else if (type.equals("# Polygons")) {
                res.add(new Polygon(linje));
            } else if (type.equals("# Rectangles")) {
                res.add(new Rektangel(linje));
            } else {
                res.add(new Sirkel(linje));
            }
        }
        return res;
    }
}

class Grafisk extends JComponent {
    ArrayList<Geometrisk> elementer;

    Grafisk (ArrayList<Geometrisk> elem) {
        elementer = elem;
        setPreferredSize(new Dimension(Geometrisk.maxX+10, Geometrisk.maxY+10));
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Geometrisk e: elementer)
            e.tegn(g2);
    }
}

abstract class Geometrisk {
    static int maxX = 0, maxY = 0;

    String farge = "";

    abstract void tegn (Graphics2D g2);

    void velgFarge (Graphics2D g2) {
        if (farge.equals("BLUE"))
            g2.setColor(Color.BLUE);
        else if (farge.equals("RED"))
            g2.setColor(Color.RED);
        else
            g2.setColor(Color.BLACK);
    }
}

class Polygon extends Geometrisk {
    int[] xPos = new int[1000], yPos = new int[1000];
    int nPunkter = 0;

    Polygon (String s) {
        String[] data = s.split(" ");
        for (String p: data) {
            if (Character.isDigit(p.charAt(0))) {
                String[] pt = p.split(",");
                xPos[nPunkter] = Integer.parseInt(pt[0]);
                maxX = Math.max(maxX, xPos[nPunkter]);
                yPos[nPunkter] = Integer.parseInt(pt[1]);
                maxY = Math.max(maxY, yPos[nPunkter]);
                nPunkter++;
            } else {
                farge = p;
            }
        }
    }

    @Override
    void tegn (Graphics2D g2) {
        velgFarge(g2);
        g2.drawPolygon(xPos, yPos, nPunkter);
    }
}

class Rektangel extends Geometrisk {
    int xPos, yPos, bredde, hoyde;

    Rektangel (String s) {
        String[] data = s.split(" ");
        xPos = Integer.parseInt(data[0]);
        yPos = Integer.parseInt(data[1]);
        bredde = Integer.parseInt(data[2]);
        hoyde = Integer.parseInt(data[3]);
        maxX = Math.max(maxX, xPos+bredde);
        maxY = Math.max(maxY, yPos+hoyde);
        if (data.length > 4)
            farge = data[4];
    }

    @Override
    void tegn (Graphics2D g2) {
        velgFarge(g2);
        g2.drawRect(xPos,yPos, bredde,hoyde);
    }
}

class Sirkel extends Geometrisk {
    int xPos, yPos, radius;

    Sirkel (String s) {
        String[] data = s.split(" ");
        xPos = Integer.parseInt(data[0]);
        yPos = Integer.parseInt(data[1]);
        radius = Integer.parseInt(data[2]);
        maxX = Math.max(maxX, xPos+radius);
        maxY = Math.max(maxY, yPos+radius);
        if (data.length > 3)
            farge = data[3];
    }

    @Override
    void tegn (Graphics2D g2) {
        velgFarge(g2);
        g2.drawOval(xPos-radius,yPos-radius, 2*radius,2*radius);
    }
}