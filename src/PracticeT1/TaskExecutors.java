package PracticeT1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class TaskExecutors {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Random rand = new Random();
        ArrayList<Future<Double>> resultList = new ArrayList<>();

        for(int i=0;i<10;i++){
            Task t = new Task(rand.nextInt(100));
            Future<Double> fu = executor.submit(t);
            resultList.add(fu);
        }

        do{
            System.out.println("Main: no. of Completed Tasks :"+executor.getCompletedTaskCount());

            for(int i=0;i<10;i++){
                Future<Double> fu = resultList.get(i);
                System.out.println("Main : Task "+i+" Status :"+fu.isDone());
            }

            try{
                TimeUnit.MICROSECONDS.sleep(50);
            }catch (Exception e){

            }

        }while(executor.getCompletedTaskCount()<resultList.size());

        executor.shutdown();

        try{
            for(Future<Double> fu: resultList){
                System.out.println("--> VAL :"+fu.get());
            }
        }catch (Exception e){

        }



    }
}

class Task implements Callable<Double>{

    Integer num;

    Task(Integer n){
        num = n;
    }

    public Double call(){
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }catch (Exception e){

        }
        return Math.sin(num);
    }
}
