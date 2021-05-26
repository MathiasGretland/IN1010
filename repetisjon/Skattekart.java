package repetisjon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skattekart {
    private char[][] kart;
    private int hoyde;
    private int bredde;
    private boolean funnet = false;

    private Skattekart(char[][] kart, int hoyde, int bredde){
        this.kart = kart;
        this.hoyde = hoyde;
        this.bredde = bredde;
    }

    static Skattekart lesInn(File filnavn){
        Scanner inf;
        try {
            inf = new Scanner(filnavn);
        } catch (FileNotFoundException exception) {
            System.out.println("Fant ikke filen");
            inf = new Scanner("");
        }
        String linje = inf.nextLine();
        String[] data = linje.split(" ");
        int antR = Integer.parseInt(data[0]);
        int antK = Integer.parseInt(data[1]);
        char[][] kart = new char[antR][antK];
        int radInne = 0;
        int kolonneInne = 0;
        for (int rad = 0; rad < antR; rad++) {
            String l = inf.nextLine();

            for (int kol = 0; kol < antK; kol++) {
                kart[rad][kol] = l.charAt(kol);
            }
        }
        Skattekart skattekart = new Skattekart(kart, antR, antK);
        return skattekart;
    }

    public void skrivUt(){
        char[][] fakeKart = new char[hoyde][bredde];
        for (int rad = 0; rad < hoyde; rad++){
            for (int kol = 0; kol < bredde; kol++){
                fakeKart[rad][kol] = 'X';
            }
        }

        if (funnet){
            for (int i = 0; i < kart.length; i++){
                System.out.println(kart[i]);
            }
        } else {
            for (int i = 0; i < fakeKart.length; i++){
                System.out.println(fakeKart[i]);
            }
        }
    }

    public boolean sjekk(int rad, int kol){
        if (kart[rad][kol] == 'X'){
            return funnet = true;
        }
        return funnet = false;
    }

    public static void main(String[] args) {
        Skattekart skattekart;
        File fil = new File("repetisjon/kart.txt");
        skattekart = Skattekart.lesInn(fil);

        skattekart.skrivUt();
        System.out.println();
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Finn skatten! Gjett koordinater paa formatet (rad kol) (a for aa avslutte)");
        String inn = input.nextLine();
        while (inn != "a"){
            String [] l = inn.split(" ");
            int rad = Integer.parseInt(l[0]);
            int kolonne = Integer.parseInt(l[1]);
            skattekart.sjekk(rad,kolonne);
            if (skattekart.funnet){
                System.out.println();
                System.out.println("Du fant skatten!");
                skattekart.skrivUt();
                return;
            }
            else {
                System.out.println();
                System.out.println("Ingen skatt der! Gjett igjen:");
                inn = input.nextLine();
            }
        }
    }
}
