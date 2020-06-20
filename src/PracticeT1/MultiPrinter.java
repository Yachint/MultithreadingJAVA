package PracticeT1;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MultiPrinter {
    public static void main(String[] args) {
        int n = 3;

        PrintQueue queue = new PrintQueue(n);

        Man1[] m1 = new Man1[5];
        Man2[] m2 = new Man2[5];
        Man3[] m3 = new Man3[5];

        for(int i=0;i<5;i++){
            m1[i] = new Man1(queue);
            m2[i] = new Man2(queue);
            m3[i] = new Man3(queue);

            m1[i].start();
            m2[i].start();
            m3[i].start();
        }
    }
}

class PrintQueue{
    boolean[] printers;
    Semaphore sem;

    PrintQueue(int num){
        printers = new boolean[num];
        for(boolean b: printers) b = false;
        sem = new Semaphore(num);
    }

    void Print(String message){
        int index=0;
        Random random = new Random();
        try{
            sem.acquire();
            System.out.println(Thread.currentThread().getName()+" Searching for free Printer");
            //TimeUnit.SECONDS.sleep(1);

            synchronized (this) {
                for(int i=0;i<this.printers.length;i++){
                    if(!printers[i]){
                        index = i;
                        System.out.println(Thread.currentThread().getName()+" Assigned to printer :"+(index+1));
                        printers[i] = true;
                        break;
                    }
                }
            }

            System.out.println(Thread.currentThread().getName()+" Printing :"+message);
            TimeUnit.SECONDS.sleep(random.nextInt(10));
            printers[index] = false;
            System.out.println(Thread.currentThread().getName()+" Releasing Lock and Freeing printer :"+(index+1));
            //TimeUnit.SECONDS.sleep(1);
            sem.release();


        }catch(Exception e){
            System.out.println("Error :"+e);
        }
    }
}


class Man1 extends Thread{

    PrintQueue queue;

    Man1(PrintQueue q){
        queue = q;
    }

    public void run(){
        queue.Print("JOB1 Data sheet....");
    }
}

class Man2 extends Thread{

    PrintQueue queue;

    Man2(PrintQueue q){
        queue = q;
    }

    public void run(){
        queue.Print("CLASS 2 Data sheet....");
    }
}

class Man3 extends Thread{

    PrintQueue queue;

    Man3(PrintQueue q){
        queue = q;
    }

    public void run(){
        queue.Print("ORG 3 Data sheet....");
    }
}