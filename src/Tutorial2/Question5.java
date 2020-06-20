public class Question5 {
    public static void main(String[] args) {
        childThreadExample e1 = new childThreadExample();
        e1.start();

        try{
            System.out.println("Current Thread: "+ Thread.currentThread().getName());
            e1.join();
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Exception has" +" been caught" + e);
        }

        System.out.println("Exiting Thread: "+ Thread.currentThread().getName());
    }
}

class childThreadExample extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
            System.out.println("Current Thread: "+Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Exception has" +" been caught" + e);
        }

        System.out.println("Exiting Thread: "+ Thread.currentThread().getName());

    }
}
