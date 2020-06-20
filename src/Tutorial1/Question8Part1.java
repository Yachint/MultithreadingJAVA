import java.util.Scanner;

public class Question8Part1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();

        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = s.nextInt();
        }

        SelectionSort(arr,size);

        for(int item : arr){
            System.out.print(item + " ");
        }
    }

    static void SelectionSort(int[] arr, int n){

        for(int i=0;i<n-1;i++){
            int min_idx = i;

            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_idx])
                    min_idx = j;
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
}
