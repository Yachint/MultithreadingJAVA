import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Tut4Ques7 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arr = new Integer[50];
        for(int i=0;i<50;i++){
            arr[i] = random.nextInt(100);
        }

        System.out.println("Original Array :");
        System.out.println(Arrays.toString(arr));

        ArrayList<SortTask> taskList = new ArrayList<>();
        taskList.add(new SortTask(arr,0));
        taskList.add(new SortTask(arr,1));
        taskList.add(new SortTask(arr,2));

        ExecutorService executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Result finalResult;


        try{
            finalResult = executor.invokeAny(taskList);
            System.out.println("MAIN : Result of fastest sort are :");
            System.out.println(finalResult.algo);
            System.out.println(Arrays.toString(finalResult.arr));
        }catch(Exception e){
            System.out.println("Exception :"+e);
        }

        executor.shutdown();

    }
}

class Result{
    Integer[] arr;
    String algo;

    Result(Integer[] array, String name){
        this.arr= array;
        this.algo = name;
    }
}

class SortTask implements Callable<Result>{

    Integer[] arr;
    int sortMethod;

    SortTask(Integer[] array, int sortMethod){
        this.arr = array;
        this.sortMethod = sortMethod;
    }

    @Override
    public Result call() throws Exception {
        if(sortMethod==0) {
            SelectionSort(arr,arr.length);
            return new Result(this.arr,"SELECTION SORT");
        }
        else if(sortMethod==1){
            sort(arr,0,arr.length-1);
            return new Result(this.arr,"MERGE SORT");
        }
        else {
            Arrays.sort(arr);
            return new Result(this.arr,"IN BUILT SORT");
        }


    }

    void SelectionSort(Integer[] arr, int n){

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

    static void merge(Integer[] arr, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i<n1;i++) L[i] = arr[l+i];
        for(int j=0;j<n2;j++) R[j] = arr[m+j+1];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(Integer[] arr,int l, int r){
        if(l<r){

            int m = (l+r)/2;

            sort(arr,l,m);
            sort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

}





