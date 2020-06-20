package PracticeT2;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeTest {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<Integer> cdq = new ConcurrentLinkedDeque<>();

        addTokens[] atok = new addTokens[5];
        delTokens[] dtok = new delTokens[5];

        for(int i=0;i<5;i++){
            atok[i] = new addTokens(cdq);
            new Thread(atok[i]).start();
            System.out.println("ADD --- "+cdq);
        }

        for(int i=0;i<5;i++){
            dtok[i] = new delTokens(cdq);
            new Thread(dtok[i]).start();
            System.out.println("DEL === "+cdq);
        }
    }
}

class delTokens implements Runnable {

    ConcurrentLinkedDeque<Integer> cdq;

    delTokens(ConcurrentLinkedDeque<Integer> q){
        cdq = q;
    }

    public void run(){
        cdq.remove();
    }
}

class addTokens implements Runnable {

    ConcurrentLinkedDeque<Integer> cdq;

    addTokens(ConcurrentLinkedDeque<Integer> q){
        cdq = q;
    }

    @Override
    public void run() {
        Random random = new Random();
        cdq.add(random.nextInt(1000));
    }
}
