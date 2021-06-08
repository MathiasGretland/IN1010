package traader;

public class Postmann implements Runnable {
    Postkontor postkontor;

    public Postmann(Postkontor postkontor) {
        this.postkontor = postkontor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                Post p = new Pakke("PLZ RESPOND I GOT COOKIES", "Magnus");
                postkontor.leverPost(p);
            }
            else {
                Post p = new Pakke("SKRT DAB", "Lasse");
                postkontor.leverPost(p);
            }

        }
    }
}