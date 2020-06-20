//package PracticeT1;
//
//import java.util.concurrent.TimeUnit;
//
//public class ProdConsSingle {
//    public static void main(String[] args) {
//        Resource r = new Resource();
//
//        Producer p1 = new Producer(1,r);
//        Consumer c1 = new Consumer(r);
//
//        p1.start();
//        c1.start();
//
//    }
//}
//
//class Resource{
//    int n;
//    boolean flag = false;
//
//    synchronized void put(int token){
//       try{
//        if(flag) wait();
//        else{
//            this.n = token;
//            System.out.println("PRODUCE : "+n);
//
//            flag = true;
//            notify();
//        }
//       }catch (Exception e){
//           System.out.println("Error :"+ e);
//       }
//    }
//
//    synchronized void get(){
//        try{
//            if(!flag) wait();
//            else{
//                System.out.println("CONSUME : "+n);
//
//                flag = false;
//                notify();
//            }
//        }catch (Exception e){
//            System.out.println("Error :"+ e);
//        }
//    }
//
//}
//
//class Producer extends Thread{
//
//    int n;
//    Resource r1;
//
//    Producer(int am, Resource r){
//        n = am;
//        r1 = r;
//    }
//
//    @Override
//    public void run() {
//        try{
//            while(true){
//                r1.put(n);
//                this.n++;
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }catch(Exception e){
//
//        }
//    }
//}
//
//class Consumer extends Thread{
//
//    Resource r1;
//
//    Consumer(Resource r){
//        r1 = r;
//    }
//
//    public void run(){
//        try{
//            while(true){
//                r1.get();
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }catch(Exception e){
//
//        }
//    }
//}
