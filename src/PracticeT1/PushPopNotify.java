package PracticeT1;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class PushPopNotify {
    public static void main(String[] args) {
        SharedMonitor m = new SharedMonitor();
        Random random = new Random();

        Pop[] pops = new Pop[10];
        Push[] pushes = new Push[10];

        for(int i=0;i<10;i++){
            pops[i] = new Pop(m);
            pushes[i] = new Push(random.nextInt(100),m);

            pushes[i].start();
            pops[i].start();

        }
    }
}

class SharedMonitor {
    Stack<Integer> st;

    SharedMonitor(){
        st = new Stack<>();
    }

    synchronized void pushInStack(int num){
        try {
            this.st.push(num);
            System.out.println(num+" PUSHED IN STACK!");
            //TimeUnit.SECONDS.sleep(1);
            printStack();
            System.out.println("");
            //TimeUnit.SECONDS.sleep(1);
            notify();
        }catch(Exception e){
            System.out.println("Error :"+e);
        }
    }

    synchronized void popFromStack(){
        try{
            if(this.st.isEmpty()){
                System.out.println("!! STACK EMPTY, WAITING... !!");
                wait();
            }else{
                int t = this.st.pop();
                System.out.println(t+" POPPED FROM STACK!");
                //TimeUnit.SECONDS.sleep(1);
                printStack();
                System.out.println("");
                //TimeUnit.SECONDS.sleep(1);
            }
        }catch(Exception e){
            System.out.println("Error :"+e);
        }
    }

    synchronized void printStack() {
        if(st.empty()) return;

        int x = st.peek();
        st.pop();

        this.printStack();

        System.out.print(x + " ");

        st.push(x);
    }
}

class Push extends Thread{
    int num;
    SharedMonitor m;

    Push(int num, SharedMonitor m){
        this.num = num;
        this.m = m;
    }

    public void run(){
        m.pushInStack(num);
    }
}

class Pop extends Thread {
    SharedMonitor m;

    Pop(SharedMonitor m){
        this.m = m;
    }

    public void run(){
        m.popFromStack();
    }

}