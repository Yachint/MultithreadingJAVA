package PracticeT2;
import java.util.Random;
import java.util.concurrent.*;

public class LinkedBlockingDequeueTest {

    public static void main(String[] args){
        LinkedBlockingDeque<Integer> lbqDeque = new LinkedBlockingDeque<>();

        deleteExistingBlocks[] delBlocks = new deleteExistingBlocks[5];
        addNewBlocks[] addBlocks = new addNewBlocks[5];

        for(int i=0;i<5;i++){
            addBlocks[i] = new addNewBlocks(lbqDeque);
            addBlocks[i].start();
            System.out.println("ADD : ---    "+lbqDeque);
        }

        for(int i=0;i<5;i++){
            delBlocks[i] = new deleteExistingBlocks(lbqDeque);
            delBlocks[i].start();
            System.out.println("DEL : ===   "+lbqDeque);
        }
    }
}

class deleteExistingBlocks extends Thread {
    LinkedBlockingDeque<Integer> lbq;

    deleteExistingBlocks(LinkedBlockingDeque<Integer> newQueue){
        lbq = newQueue;
    }

    public void run(){
        Random rand = new Random();
        try {
            lbq.take();
        } catch(Exception e) {

        }
    }
}

class addNewBlocks extends Thread {
    LinkedBlockingDeque<Integer> lbq;

    addNewBlocks(LinkedBlockingDeque<Integer> newQueue){
        lbq = newQueue;
    }

    public void run(){
        Random rand = new Random();
        int k = rand.nextInt(1000);
        System.out.println("ADDING : "+k);
        lbq.add(k);
    }
}