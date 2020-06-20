import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class Tut4Ques5 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        ArrayList<Future<Integer>> resultList= new ArrayList<>();
        Random random = new Random();

        for(int i=0;i<4;i++){
            Task t = new Task(random.nextInt(10));
            Future<Integer> futureObj = executor.submit(t);
            resultList.add(futureObj);
        }

        do{
            System.out.println("Main: no. of Completed Tasks :"+executor.getCompletedTaskCount());

            for(int i=0;i<4;i++){
                Future<Integer> fu = resultList.get(i);
                System.out.println("Main : Task "+i+" Status :"+fu.isDone());
            }

            try{
                TimeUnit.MICROSECONDS.sleep(50);
            }catch (Exception e){

            }

        }while (executor.getCompletedTaskCount() < resultList.size());

        executor.shutdown();
    }
}

class Task implements Callable<Integer> {
    int number;

    Task(int num){
        this.number = num;
    }

    @Override
    public Integer call() throws Exception {
        int prod = 1;

        for(int i=1;i<=number;i++){
            prod = prod*i;
        }

        TimeUnit.SECONDS.sleep(2);
        System.out.println("Factorial of "+number+" is :"+prod);

        return prod;
    }
}

