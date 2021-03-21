package uke9.Postkontor;

public class Kunde implements Runnable{
    String navn;
    Postkontor postkontor;

    public Kunde(String navn, Postkontor postkontor){
        this.navn = navn;
        this.postkontor = postkontor;
    }

    @Override
    public void run() {
        while (true){
            Post p = postkontor.hentPost(navn);
            if (p != null){
                System.out.println(p.toString());
            }
        }
    }
}
