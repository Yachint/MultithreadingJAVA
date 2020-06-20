import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {

        Scanner s  = new Scanner(System.in);
        System.out.println("Enter String :");
        String sentence = s.nextLine();

        System.out.println("Enter Array Size :");
        int n = s.nextInt();

        Integer[] arr = new Integer[n];

        System.out.println("Enter the elements :");
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }

        childThread c1 = new childThread(arr,sentence);

        c1.start();
        doWork(arr,sentence);



    }

    static void doWork(Integer[] arr, String s){
        int count = s.replaceAll("[^aeiouAEIOU]","").length();
        System.out.println("No. of vowels :"+count);

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println("Sorted Array in Reverse Order :"+Arrays.toString(arr));
    }
}

class childThread extends Thread{

    Integer[] cArr;
    String str;

    childThread(Integer[] arr, String s){
        this.cArr = arr;
        this.str = s;
    }

    @Override
    public void run() {
        String[] arr = str.split(" ");
        System.out.println("No. of Words :"+arr.length);

        Arrays.sort(this.cArr);
        System.out.println("Sorted Array in Ascending Order :"+Arrays.toString(this.cArr));

    }
}
