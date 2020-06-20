import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class TutQuestion3 {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        Random rand = new Random();

        int t = s.nextInt();

        Integer[] arr = new Integer[t];

        System.out.print("[ ");
        for(int i=0;i<t;i++){
            arr[i] = rand.nextInt(1000);
            System.out.print(arr[i]+" ");
        }
        System.out.print(" ]");
        System.out.println("");

        ResourceArray re = new ResourceArray(arr);

        NormalSort n1 = new NormalSort(re);
        ReverseSort r1 = new ReverseSort(re);



        try{
            n1.start();
            r1.start();

        }catch(Exception e){

        }
    }
}

class ResourceArray {
    Integer[] arr;

    ResourceArray(Integer[] arr){
        this.arr = arr;
    }

    synchronized void Nsort(){
        System.out.println("Starting Reverse Sort....");
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(" ]");
        System.out.println("");

        System.out.println("Exiting Reverse Sort....");
    }

    synchronized void sort(){
        System.out.println("Starting Normal Sort....");
        Arrays.sort(arr);
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(" ]");
        System.out.println("");

        System.out.println("Exiting Normal Sort ....");
    }


}

class NormalSort extends Thread {

    ResourceArray re;

    NormalSort(ResourceArray resource){
        re = resource;
    }

    @Override
    public void run() {
        re.sort();
    }
}

class ReverseSort extends Thread {
    ResourceArray re;

    ReverseSort(ResourceArray resource){
        re = resource;
    }

    @Override
    public void run() {
        re.Nsort();
    }
}
