import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        myThread1[] arr1 = new myThread1[n];
        myThread2[] arr2 = new myThread2[n];

        for(int i=0;i<n;i++){
            arr1[i] = new myThread1();
            arr2[i] = new myThread2();
        }

        for(int i=0;i<n;i++){
            arr1[i].start();
            Thread newThread = new Thread(arr2[i]);
            newThread.start();
        }
    }
}

class myThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("This is Runnable Thread...");
    }
}

class myThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("This is Thread Class Extension...");
    }
}