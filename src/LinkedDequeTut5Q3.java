import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedDequeTut5Q3 {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> blockedList = new LinkedBlockingDeque<>();

        addNewItems[] addArr = new addNewItems[10];
        deleteItems[] delArr = new deleteItems[10];

        for(int i=0;i<10;i++){

            addArr[i] = new addNewItems(blockedList);

            addArr[i].start();

            System.out.println(blockedList);
        }

        for(int i=0;i<10;i++){

            delArr[i] = new deleteItems(blockedList);

            delArr[i].start();

            System.out.println(blockedList);
        }


    }
}

class deleteItems extends Thread{

    LinkedBlockingDeque<Integer> queue;

    deleteItems(LinkedBlockingDeque<Integer> conL){
        this.queue = conL;
    }

    @Override
    public void run() {
        try{
            this.queue.take();
        }catch (Exception e){
            System.out.println("Error :"+e);
        }

    }
}

class addNewItems extends Thread{

    LinkedBlockingDeque<Integer> queue;

    addNewItems(LinkedBlockingDeque<Integer> conL){
        this.queue = conL;
    }

    @Override
    public void run() {
        Random random = new Random();
        this.queue.add(random.nextInt(1000));
    }
}
