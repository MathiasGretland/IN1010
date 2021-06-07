package utfordringer;

import java.util.ArrayList;
import java.util.Scanner;

public class KjoretoyTest {
    ArrayList<Kjoretoy> busser = new ArrayList<>();
    ArrayList<Kjoretoy> personbiler = new ArrayList<>();
    ArrayList<Kjoretoy> varebiler = new ArrayList<>();


    public String skrivSystemBeskjed(){
        String strenge = "**MENY FOR REGISTRERING AV KJØRETØY**";
        strenge += "\n1 - Registrer buss.";
        strenge += "\n2 - Registrer personbil.";
        strenge += "\n3 - Registrer varebil.";
        strenge += "\n4 - Skriv ut informasjon om kjøretøy.";


        strenge += "\n9 - Avslutt.";
        strenge += "\n";
        return strenge;
    }

    public void skrivUtInformasjon(){
        System.out.println("Informasjom om busser: \n");
        for (Kjoretoy k : busser){
            System.out.println(k);
        }
        System.out.println();
        System.out.println("Informasjom om personbiler: \n");
        for (Kjoretoy k : personbiler){
            System.out.println(k);
        }
        System.out.println();
        System.out.println("Informasjom om varebiler: \n");
        for (Kjoretoy k : varebiler){
            System.out.println(k);
        }
        System.out.println();
    }

    public void registrerBuss(){
        System.out.println("Hva er registreringsnummeret?");
        Scanner tastatur = new Scanner(System.in);
        String nummer = tastatur.nextLine();
        System.out.println("Hvilket fabrikmerke?");
        tastatur = new Scanner(System.in);
        String fabrikkmerke = tastatur.nextLine();
        System.out.println("Hvem er eieren?");
        tastatur = new Scanner(System.in);
        String eier = tastatur.nextLine();
        System.out.println("Hvor mange sitteplasser?");
        tastatur = new Scanner(System.in);
        int sitteplasser = tastatur.nextInt();
        Busser nyBuss = new Busser(nummer,fabrikkmerke,eier,sitteplasser);
        busser.add(nyBuss);
        System.out.println("Ny buss registrert! \n" + nyBuss );
    }

    public void registrerPersonbil(){
        System.out.println("Hva er registreringsnummeret?");
        Scanner tastatur = new Scanner(System.in);
        String nummer = tastatur.nextLine();
        System.out.println("Hvilket fabrikmerke?");
        tastatur = new Scanner(System.in);
        String fabrikkmerke = tastatur.nextLine();
        System.out.println("Hvem er eieren?");
        tastatur = new Scanner(System.in);
        String eier = tastatur.nextLine();
        System.out.println("Hvor mange sitteplasser?");
        tastatur = new Scanner(System.in);
        int sitteplasser = tastatur.nextInt();
        Personbiler nyBuss = new Personbiler(nummer,fabrikkmerke,eier,sitteplasser);
        personbiler.add(nyBuss);
        System.out.println("Ny personbil registrert! \n" + nyBuss );
    }

    public void registrerVarebil(){
        System.out.println("Hva er registreringsnummeret?");
        Scanner tastatur = new Scanner(System.in);
        String nummer = tastatur.nextLine();
        System.out.println("Hvilket fabrikmerke?");
        tastatur = new Scanner(System.in);
        String fabrikkmerke = tastatur.nextLine();
        System.out.println("Hvem er eieren?");
        tastatur = new Scanner(System.in);
        String eier = tastatur.nextLine();
        System.out.println("Hva er maxvekta?");
        tastatur = new Scanner(System.in);
        int maxVekt = tastatur.nextInt();
        Varebiler nyBuss = new Varebiler(nummer,fabrikkmerke,eier,maxVekt);
        varebiler.add(nyBuss);
        System.out.println("Ny varebil registrert! \n" + nyBuss );
    }

    public static void main(String[] args) {
        KjoretoyTest swag = new KjoretoyTest();
        Scanner tastatur = new Scanner(System.in);
        System.out.println(swag.skrivSystemBeskjed());
        int input = tastatur.nextInt();
        while (input != 9){
            if (input == 1){
                swag.registrerBuss();
                System.out.println();
                System.out.println(swag.skrivSystemBeskjed());
                input = tastatur.nextInt();
            }
            if (input == 2){
                swag.registrerPersonbil();
                System.out.println();
                System.out.println(swag.skrivSystemBeskjed());
                input = tastatur.nextInt();
            }
            if (input == 3){
                swag.registrerVarebil();
                System.out.println();
                System.out.println(swag.skrivSystemBeskjed());
                input = tastatur.nextInt();
            }
            if (input == 4){
                swag.skrivUtInformasjon();
                System.out.println();
                System.out.println(swag.skrivSystemBeskjed());
                input = tastatur.nextInt();
            }

        }
    }
}
