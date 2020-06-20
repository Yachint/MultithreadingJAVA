//import java.util.Arrays;
//import java.util.Random;
//import java.util.concurrent.ConcurrentLinkedDeque;
//
//public class Tutorial5Ques2 {
//    public static void main(String[] args) {
//        ConcurrentLinkedDeque<Integer> conList = new ConcurrentLinkedDeque<>();
//
//        deleteItemsToDeque[] delArr = new deleteItemsToDeque[5000];
//        addItemsToDeque[] addArr = new addItemsToDeque[5000];
//
//        for(int i=0;i<5000;i++){
//            addArr[i] = new addItemsToDeque(conList);
//
//            addArr[i].start();
//
//            System.out.println(conList);
//
//        }
//
//        for(int i=0;i<5000;i++){
//            delArr[i] = new deleteItemsToDeque(conList);
//
//            delArr[i].start();
//
//            System.out.println(conList);
//
//        }
//
//        conList.add(5);
//        conList.add(3);
//        conList.add(2);
//        conList.add(7);
//        conList.add(44);
//
//        System.out.println(conList);
//        System.out.println("Get First :"+conList.getFirst());
//        System.out.println("Get Last :"+conList.getLast());
//        System.out.println("Peek  :"+conList.peek());
//        System.out.println("Peek First :"+conList.peekFirst());
//        System.out.println("Peek Last :"+conList.peekLast());
//        System.out.println("Remove :"+conList.remove());
//        System.out.println("Remove First :"+conList.removeFirst());
//        System.out.println("Remove Last :"+conList.removeLast());
//        System.out.println("Poll first :"+conList.pollFirst());
//        System.out.println("Poll last :"+conList.pollLast());
//    }
//}
//
//class deleteItemsToDeque extends Thread {
//    ConcurrentLinkedDeque<Integer> queue;
//
//    deleteItemsToDeque(ConcurrentLinkedDeque<Integer> conL){
//        this.queue = conL;
//    }
//
//    @Override
//    public void run() {
//        queue.remove();
//    }
//}
//
//class addItemsToDeque extends Thread{
//    ConcurrentLinkedDeque<Integer> queue;
//
//    addItemsToDeque(ConcurrentLinkedDeque<Integer> conL ){
//        this.queue = conL;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        queue.add(random.nextInt(1000));
//    }
//}
