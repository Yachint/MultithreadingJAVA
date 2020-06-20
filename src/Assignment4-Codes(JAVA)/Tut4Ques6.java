import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Tut4Ques6 {
    public static void main(String[] args) {
        Server server = new Server();

        for(int i=0;i<10;i++){
            Tasks t = new Tasks("Task "+i);
            server.executeTask(t);
            //server.printStats();
        }

        server.endServer();
    }
}

class Server{
    ThreadPoolExecutor executor;

    Server(){
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    void executeTask(Tasks task){
        System.out.println("---> Task :"+task.name+" has ARRIVED");
        executor.execute(task);
        printStats();
    }

    void printStats(){
        System.out.println("---> POOL SIZE :"+executor.getPoolSize());
        System.out.println("---> ACTIVE COUNT :"+executor.getActiveCount());
        System.out.println("---> COMPLETED TASKS :"+executor.getCompletedTaskCount());
    }

    void endServer(){
        executor.shutdown();
    }
}


class Tasks implements Runnable{

    private Date startDate;
    String name;

    Tasks(String n){
        this.startDate = new Date();
        this.name = n;
    }

    @Override
    public void run() {

        Random random = new Random();

        System.out.println("Task "+name+" Init date :"+this.startDate);
        System.out.println("Task "+name+" Start date :"+new Date());

        try{
            TimeUnit.SECONDS.sleep(random.nextInt(10));
        }catch (Exception e){

        }

        System.out.println("Task "+name+" End date :"+new Date());
    }
}