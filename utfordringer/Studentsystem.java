package utfordringer;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Studentsystem {
    HashMap<Fag, Student> listeMedAlt = new HashMap<>();

    Studentsystem(){
        skrivInnFraFil();
    }

    public void skrivInnFraFil(){
        Scanner fil = null;
        String filnavn = "utfordringer/emnestudenter.txt";
        String fag = "";
        String student = "";
        try {
            fil = new Scanner(new File(filnavn));

        }catch (Exception e){
            System.out.println("Finner ikke fil " + filnavn + "!");
            System.exit(1);
        }
        while (fil.hasNextLine()){
            String input = fil.nextLine();

            if (input.charAt(0) == '*'){
                fag = input;
            }
            if (input.charAt(0) != '*'){
                student = input;
            }
            if (student != ""){
                Fag fags = new Fag(fag);
                Student students = new Student(student);
                listeMedAlt.put(fags,students);
            }
        }
    }

    public void fagAvFlestStudenter(){
        Fag fagMedMestStudenter = null;
        int teller = 0;

        for (Fag f : listeMedAlt.keySet()){
            if (fagMedMestStudenter == null){
                fagMedMestStudenter = f;
                teller++;
            }
            else if (teller == 1){

            }
        }
    }


    public void skrivUt(){
        for (Fag f : listeMedAlt.keySet()){
            System.out.println("Fag: " + f.fagNavn + " Student: " + listeMedAlt.get(f));
        }

    }

    public String skrivSystemBeskjed(){
        String strenge = "**MENY FOR STUDENT OG FAG SYSTEM**";
        strenge += "\n1 - Hvilket fag blir tatt av flest studenter.";
        strenge += "\n2 - Hvilken student tar flest fag.";
        strenge += "\n3 - Skriv ut alle fag og dens studenter.";
        strenge += "\n4 - Legge til en student til et fag.";
        strenge += "\n5 - Legge til et fag til en student.";
        strenge += "\n6 - Fjerne en student fra et fag/fjerne fag fra student.";

        strenge += "\n7 - Avslutt.";


        strenge += "\n";
        return strenge;
    }

    public static void main(String[] args) {
        Studentsystem swag = new Studentsystem();
        Scanner tastatur = new Scanner(System.in);
        System.out.println(swag.skrivSystemBeskjed());
        int input = tastatur.nextInt();
        while (input != 7){
            if (input == 1){

            }
            else if (input == 2){

            }
            else if (input == 3){
                swag.skrivUt();
            }
            else if (input == 4){

            }
            else if (input == 5){

            }
            System.out.println();
            System.out.println(swag.skrivSystemBeskjed());
            input = tastatur.nextInt();
        }


    }

}
