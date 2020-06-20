import java.util.Scanner;

public class Question8Part2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();

        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = s.nextInt();
        }

        InsertionSort(arr,size);

        for(int item : arr){
            System.out.print(item + " ");
        }
    }

    static void InsertionSort(int[] arr, int n){

        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }

            arr[j+1] = key;
        }
    }
}
