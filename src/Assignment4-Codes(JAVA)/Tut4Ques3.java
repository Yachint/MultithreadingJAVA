import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Tut4Ques3 {
    public static void main(String[] args) {
        VideoConference video = new VideoConference(10);
        video.start();

        Participant[] people = new Participant[10];

        for(int i=0;i<10;i++){
            people[i] = new Participant(video,"Participant"+i);
            Thread t1 = new Thread(people[i]);
            t1.start();
        }

    }
}

class VideoConference extends Thread{
    private CountDownLatch countDownLatch;

    VideoConference(int number){
        this.countDownLatch = new CountDownLatch(number);
    }

    void arrive(String name){
        System.out.println(name+" has Arrived!");

        this.countDownLatch.countDown();

        System.out.println("Waiting for :"+this.countDownLatch.getCount()+" more...");
    }

    @Override
    public void run() {
        System.out.println("--->Video Conference Initializing...");
        try{
            this.countDownLatch.await();

            System.out.println("--->All Participants have joined!");
            System.out.println("--->Begin!");
        }catch (Exception e){
            System.out.println("Error :"+e);
        }
    }
}

class Participant implements Runnable{

    VideoConference vd;
    String name;

    Participant(VideoConference conference, String nameInput){
        this.vd = conference;
        this.name = nameInput;
    }

    @Override
    public void run() {
        long duration  = (long)(Math.random()*10);
        try{
            TimeUnit.SECONDS.sleep(duration);
            vd.arrive(this.name);
        }catch(Exception e){
            System.out.println("Error"+e);
        }
    }
}