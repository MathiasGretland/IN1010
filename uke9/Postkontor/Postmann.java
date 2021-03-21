package uke9.Postkontor;

public class Postmann implements Runnable{

    Postkontor postkontor;

    public Postmann(Postkontor postkontor){
        this.postkontor = postkontor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                Post p = new Brev("Hei. plz answer i lone", "Morten");
                postkontor.leverPost(p);
            } else {
                Post p = new Pakke("Hei, te kush u ardered is her", "Magnus");
                postkontor.leverPost(p);
            }
        }
    }
}
