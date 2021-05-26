package repetisjon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Postkontor {
    Post[] postArray = new Post[10];
    Lock laas = new ReentrantLock();
    Condition ikkeFull = laas.newCondition();
    Condition ikkeTomt = laas.newCondition();

    public int storresle(){
        int teller = 0;
        for (int i = 0; i < postArray.length; i++){
            if (postArray[i] != null){
                teller++;
            }
        }
        return teller;
    }

    public void leverPost(Post p){
        laas.lock();
        try{
            if (storresle() == 10){
                ikkeFull.await();
            }
            for (int i = 0; i < postArray.length; i++){
                if (postArray[i] == null){
                    postArray[i] = p;
                    ikkeTomt.signalAll();
                    return;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }
    }

    public Post hentPost(String mottaker){
        laas.lock();
        try {
            if (storresle() == 0){
                ikkeTomt.await();
            }
            for (int i = 0; i < postArray.length; i++){
                if (postArray[i] != null){
                    if (postArray[i].hentMottaker().equals(mottaker)){
                        Post p = postArray[i];
                        postArray[i] = null;
                        ikkeFull.signalAll();
                        return p;
                    }
                }
            }
            ikkeTomt.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        Postkontor postkontor = new Postkontor();
        Thread postmann = new Thread(new Postmann(postkontor));
        postmann.start();

        Thread kunde1 = new Thread(new Kunde("Magnus", postkontor));
        kunde1.start();
        Thread kunde2 = new Thread(new Kunde("Lasse", postkontor));
        kunde2.start();
    }
}
