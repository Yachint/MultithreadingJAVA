import java.util.Random;

public class TutQuestion2 {
    public static void main(String[] args) {
        Random rand = new Random();

        int[] arr = new int[10];

        System.out.print("[ ");
        for(int i=0;i<10;i++){
            arr[i] = rand.nextInt(1000);
            System.out.print(arr[i]+" ");
        }
        System.out.print(" ]");
        System.out.println("");

        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }

        oddEven e = new oddEven(arr);
        negPos n = new negPos(arr);

        e.start();
        n.start();


    }
}

class oddEven extends Thread {
    int[] arr;

    oddEven(int[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        for(int n : arr){
            if(n%2==0) System.out.println(n+" is EVEN");
            else System.out.println(n+" is ODD");
        }
    }
}

class negPos extends Thread {
    int[] arr;

    negPos(int[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        for(int n : arr){
            if(n>=0) System.out.println(n+" is POS");
            else System.out.println(n+" is NEG");
        }
    }
}
