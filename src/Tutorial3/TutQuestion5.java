public class TutQuestion5 {
    public static void main(String[] args) {

        CounterThread c1 = new CounterThread();
        c1.start();
    }
}

class CounterThread extends Thread{

    int counter;

    CounterThread(){
        this.counter = 0;
    }

    @Override
    public void run() {
        while(counter<=99){
            this.counter++;
            System.out.println("COUNTER :"+counter);
            if(counter%10==0){
                System.out.println("Printing some string...");
            }
            try{
                sleep(1000);
            }catch (Exception e){
                System.out.println("Error :"+e);
            }

        }
    }
}