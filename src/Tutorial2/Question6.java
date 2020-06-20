public class Question6 {
    public static void main(String[] args) {
        myThread m1 = new myThread();
        myThread m2 = new myThread();
        myThread m3 = new myThread();

        System.out.println("t1 thread priority : " + m1.getPriority());
        System.out.println("t2 thread priority : " + m2.getPriority());
        System.out.println("t3 thread priority : " + m3.getPriority());

        m1.setPriority(2);
        m2.setPriority(5);
        m3.setPriority(8);

        System.out.println("t1 thread priority : " + m1.getPriority());
        System.out.println("t2 thread priority : " + m2.getPriority());
        System.out.println("t3 thread priority : " + m3.getPriority());

        m1.start();;
        m2.start();
        m3.start();

        System.out.print(Thread.currentThread().getName());
        System.out.println("Main thread priority : "
                + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(10);
        System.out.println("Main thread priority : "
                + Thread.currentThread().getPriority());
    }
}

class myThread extends Thread{
    @Override
    public void run() {
        try{
            sleep(5000);
            System.out.println("In Thread :"+Thread.currentThread().getName()+" -- ID "
                    +Thread.currentThread().getId()
                    +"  PRIORITY :"+Thread.currentThread().getPriority());
        }catch (Exception e){
            System.out.println("Exception has" +" been caught" + e);
        }
    }
}