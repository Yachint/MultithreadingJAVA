import java.util.Random;
import java.util.concurrent.*;

public class QuestionT1 {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Random rand = new Random();
        int num = rand.nextInt(10);
        System.out.println("Num :"+num);

        Task1 task1 = new Task1(num);
        Task2 task2 = new Task2(num);
        Task3 task3 = new Task3(num);

        Future<Double> fu1 = executor.submit(task1);
        Future<Boolean> fu2 = executor.submit(task2);
        Future<Integer> fu3 = executor.submit(task3);

        executor.shutdown();

        System.out.println("Result 1 :"+fu1.get());
        System.out.println("Result 2 :"+fu2.get());
        System.out.println("Result 3 :"+fu3.get());

    }
}

class Task3 implements Callable<Integer>{

    Integer num;

    Task3(Integer n){
        num = n;
    }

    public Integer call(){
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }catch (Exception e){

        }
        int fact = 1;
        for(int i=2;i<=num;i++) fact *= i;
        return fact;
    }
}

class Task2 implements Callable<Boolean>{

    Integer num;

    Task2(Integer n){
        num = n;
    }

    public Boolean call(){
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }catch (Exception e){

        }
        if(num%2==0) return false;
        else return true;
    }
}

class Task1 implements Callable<Double> {

    Integer num;

    Task1(Integer n){
        num = n;
    }

    public Double call(){
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }catch (Exception e){

        }
        return (double)(num*num*num);
    }
}
