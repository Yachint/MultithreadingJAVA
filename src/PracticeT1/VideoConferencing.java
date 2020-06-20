package PracticeT1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VideoConferencing {
    public static void main(String[] args) {
        Conference conference = new Conference(10);

        conference.start();

        for(int i=0;i<10;i++){
            Participant p1 = new Participant("Participant "+(i+1),conference);
            p1.start();
        }
    }
}

class Conference extends Thread{
    CountDownLatch latch;

    Conference(int num){
        latch = new CountDownLatch(num);
    }

    void arrive(String name){
        latch.countDown();
        System.out.println(name+" has arrived, "+latch.getCount()+" to go...");

    }

    public void run(){
        System.out.println("Initializing conference...");

        try{
            latch.await();
            System.out.println("All participants have appeared!, Begin :)");
        }catch(Exception e){
            System.out.println("Error :"+e);
        }
    }

}

class Participant extends Thread{
    String name;
    Conference video;

    Participant(String n, Conference v){
        name = n;
        video = v;
    }

    public void run(){
        try {
            Random random = new Random();
            TimeUnit.SECONDS.sleep(random.nextInt(10));
            video.arrive(name);
            System.out.println("Imma go now...");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
