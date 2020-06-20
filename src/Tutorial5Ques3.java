import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Tutorial5Ques3 {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> blockedList = new LinkedBlockingDeque<>();

        addItems[] addArr = new addItems[10];
        delItems[] delArr = new delItems[10];

        for(int i=0;i<10;i++){

            addArr[i] = new addItems(blockedList);

            addArr[i].start();

            System.out.println(blockedList);
        }

        for(int i=0;i<10;i++){

            delArr[i] = new delItems(blockedList);

            delArr[i].start();

            System.out.println(blockedList);
        }


    }
}

class delItems extends Thread{

    LinkedBlockingDeque<Integer> queue;

    delItems(LinkedBlockingDeque<Integer> conL){
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

class addItems extends Thread{

    LinkedBlockingDeque<Integer> queue;

    addItems(LinkedBlockingDeque<Integer> conL){
        this.queue = conL;
    }

    @Override
    public void run() {
        Random random = new Random();
        this.queue.add(random.nextInt(1000));
    }
}
