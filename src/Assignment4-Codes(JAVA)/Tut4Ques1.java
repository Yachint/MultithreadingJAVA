import java.util.concurrent.*;
import java.util.*;

public class Tut4Ques1 {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        PrintQueueSingle pq = new PrintQueueSingle(s);

        Job[] jobs = new Job[10];

        for(int i=0;i<10;i++){
            jobs[i] = new Job(pq);
            jobs[i].start();
        }

    }
}

class PrintQueueSingle {
    Semaphore sem;

    PrintQueueSingle(Semaphore sema){
        this.sem = sema;
    }

    void print() {
        try {
            sem.acquire();
            System.out.println(Thread.currentThread().getName() + " : Has Accquired the LOCK!");
            System.out.println("printMessage of : " + Thread.currentThread().getName());

            System.out.println(Thread.currentThread().getName() + " : Releasing lock ...");
            Thread.sleep(1500);
            sem.release();

        } catch (Exception e) {
            System.out.println("ERROR :" + e);
        }

    }
}

class Job extends Thread{

    PrintQueueSingle q;

    Job(PrintQueueSingle queue){
        this.q = queue;
    }

    public void run() {
        q.print();
    }
}