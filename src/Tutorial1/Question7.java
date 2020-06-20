import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int size = s.nextInt();

        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = s.nextInt();
        }

        BubbleSort(arr,size);

        for(int item : arr){
            System.out.print(item + " ");
        }


    }

    static void BubbleSort(int[] arr, int n){
        boolean flag;

        for(int i=0;i<n-1;i++){
            flag = false;
            for(int j =0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag = true;
                }
            }

            if(!flag) break;
        }
    }
}
