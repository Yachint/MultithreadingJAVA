public class TutQuestion6 {
    public static void main(String[] args) {
        ThreadRunner th1 = new ThreadRunner();
        th1.start();

        for(int i=0;i<5;i++){
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+" IN CONTROL");
        }

        ThreadRunner th2 = new ThreadRunner();
        th2.start();

        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" IN CONTROL");
            }catch (Exception e){

            }

        }

        Thread th3 = new ThreadRunner();
        th3.start();


        for(int i=0;i<5;i++){
            try {
                th3.join();
                System.out.println(Thread.currentThread().getName()+" IN CONTROL");
            }catch (Exception e){

            }
        }
    }
}

class ThreadRunner extends Thread{
    @Override
    public void run() {
        try{
            for(int i=0;i<5;i++)
            System.out.println(Thread.currentThread().getName()+" IN CONTROL");
        }catch (Exception e){
            System.out.println("Exception :"+e);
        }
    }
}
