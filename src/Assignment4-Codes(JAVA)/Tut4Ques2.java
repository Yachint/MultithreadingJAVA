import java.util.concurrent.*;
import java.util.*;

public class Tut4Ques2 {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(3);
        PrintQueue pq = new PrintQueue(s);

        Job1[] arr1 = new Job1[5];
        Job2[] arr2 = new Job2[5];
        Job3[] arr3 = new Job3[5];

        for(int i=0;i<5;i++){
            arr1[i] = new Job1(pq);
            arr2[i] = new Job2(pq);
            arr3[i] = new Job3(pq);

            arr1[i].start();
            arr2[i].start();
            arr3[i].start();
        }

    }
}

class PrintQueue {
    Semaphore sem;
    boolean[] printers;

    PrintQueue(Semaphore sema){
        this.sem = sema;
        printers = new boolean[3];

        for(boolean t: printers) {
            t = false;
        }
    }

    void print(String printMessage) {
        int freePrinter=0;

        //System.out.println(Thread.currentThread().getName()+" : Waiting to aquire lock ...");
        try {

            sem.acquire();

            System.out.println(Thread.currentThread().getName()+" : Has Accquired the LOCK!");

            synchronized (this){
                for(int i=0;i<3;i++) {
                    if(this.printers[i]==false) {
                        this.printers[i] = true;
                        freePrinter = i;
                        break;
                    }
                }
            }

            System.out.println("USING PRINTER NO."+(freePrinter+1)+" --->"+printMessage);

            //Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName()+" : Releasing lock ...");
            Thread.sleep(1500);
            System.out.println("Freeing printer :"+(freePrinter+1));
            this.printers[freePrinter] = false;

//            Thread.sleep(2500);
//            System.out.print("Current Printer STATUS :");
//            System.out.print(Arrays.toString(this.printers));
//            System.out.println("");
            sem.release();

        }catch(Exception e) {
            System.out.println("ERROR :"+e);
        }

    }
}

class Job1 extends Thread{

    PrintQueue q;

    Job1(PrintQueue queue){
        this.q = queue;
    }

    public void run() {
        q.print("Printing Job 1 ....");
    }
}

class Job2 extends Thread{

    PrintQueue q;

    Job2(PrintQueue queue){
        this.q = queue;
    }

    public void run() {
        q.print("Printing Job 2 ....");
    }
}

class Job3 extends Thread{

    PrintQueue q;

    Job3(PrintQueue queue){
        this.q = queue;
    }

    public void run() {
        q.print("Printing Job 3 ....");
    }
}