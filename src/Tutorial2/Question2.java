import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        pThread1 p1 = new pThread1(num);
        pThread2 p2 = new pThread2(num);

        Thread t1 = new Thread(p2, "Runnable");
        t1.start();
        p1.start();


    }
}

class pThread2 implements Runnable{

    int num;

    pThread2(int x){
        this.num = x;
    }

    @Override
    public void run() {

        if(num<=1){
            System.out.println("NOT PRIME!");
            return;
        }
        if(num<=3){
            System.out.println("PRIME!");
            return;
        }
        if(num%2==0 || num%3==0){
            System.out.println("NOT PRIME! Div by 2 or 3");
            return;
        }

        for(int i=5;i*i<=num;i=i+6){
            if(num%i==0 || num%(i+2)==0 ) {
                System.out.println("NOT PRIME! Div by "+i+" or "+(i+2));
                return;
            }
        }

        System.out.println("PRIME!");
    }
}

class pThread1 extends Thread{

    int num;

    pThread1(int x){
        this.num = x;
    }

    @Override
    public void run() {
        if(num<=1){
            System.out.println("NOT PRIME!");
            return;
        }
        if(num<=3){
            System.out.println("PRIME!");
            return;
        }
        if(num%2==0 || num%3==0){
            System.out.println("NOT PRIME! Div by 2 or 3");
            return;
        }

        for(int i=5;i*i<=num;i=i+6){
            if(num%i==0 || num%(i+2)==0 ) {
                System.out.println("NOT PRIME! Div by "+i+" or "+(i+2));
                return;
            }
        }

        System.out.println("PRIME!");
    }
}