package uke9.Postkontor;

class Hovedprogram{
    public static void main(String[] args) {

        Postkontor postkontor = new Postkontor();

        Postmann postmann = new Postmann(postkontor);
        Thread traad = new Thread(postmann);
        traad.start();

        Kunde kunde1 = new Kunde("Magnus", postkontor);
        Thread traad2 = new Thread(kunde1);
        traad2.start();

        Kunde kunde2 = new Kunde("Morten", postkontor);
        Thread traad3 = new Thread(kunde2);
        traad3.start();
    }
}