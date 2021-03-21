package uke9.Postkontor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Postkontor {
    Post [] liste = new Post[10];

    Lock laas = new ReentrantLock();
    Condition ikkeFull = laas.newCondition();
    Condition ikkeTom = laas.newCondition();

    public int storrelse(){
        int teller = 0;
        for (int i = 0; i < liste.length; i++){
            if (liste[i] != null){
                teller++;
            }
        }
        return teller;
    }


    public void leverPost(Post p){
        laas.lock();
        try {
            if (storrelse() == 10){
                ikkeFull.await();
            }
            for (int i = 0; i < liste.length; i++){
                if (liste[i] == null){
                    liste[i] = p;
                    ikkeTom.signal();
                    return;
                }
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }
        finally {
            laas.unlock();
        }
    }

    public Post hentPost(String mottaker){
        laas.lock();
        try {
            if (storrelse() == 0){
                ikkeTom.await();
            }
            for (int i = 0; i < liste.length; i++){
                if (liste[i] != null){
                    if (liste[i].hentMottaker().equals(mottaker)){
                        Post p = liste[i];
                        liste[i] = null;
                        ikkeFull.signal();
                        return p;
                    }
                }
            }
            ikkeTom.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            laas.unlock();
        }
        return null;
    }
}
