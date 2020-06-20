package PracticeT1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatGrouper {
    public static void main(String[] args) {
        MatrixDouble mat = new MatrixDouble(10000,1000,5);
        Results res = new Results(10000);
        Grouper grouper = new Grouper(res);

        CyclicBarrier barrier = new CyclicBarrier(6);

        Searcher[] searchers = new Searcher[5];

        for(int i=0;i<5;i++){
            searchers[i] = new Searcher(i*2000,(i*2000)+2000,5,mat,res,barrier);
            searchers[i].start();
        }

        try
        {
            barrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }

        Thread g = new Thread(grouper);
        g.start();
    }
}

class MatrixDouble{
    int[][] data;

    MatrixDouble(int row, int col, int num){

        data = new int[row][col];
        Random random = new Random();
        int count = 0;

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                data[i][j] = random.nextInt(10);
                if(data[i][j] == num){
                    count++;
                }
            }

        System.out.println("OG count :"+count);
    }

    int[] getRow(int r){
        if(r>=0 && r<data.length){
            return data[r];
        }

        return null;
    }

}

class Results{
    int[] data;

    Results(int size){
        data = new int[size];
    }
}

class Searcher extends Thread{

    int firstRow, lastRow, number;
    MatrixDouble md;
    Results rs;
    CyclicBarrier barrier;

    Searcher(int fr, int lr, int num, MatrixDouble m, Results r, CyclicBarrier b){
        firstRow = fr;
        lastRow = lr;
        number = num;
        md = m;
        rs = r;
        barrier = b;
    }

    public void run(){

        for(int i=firstRow;i<lastRow;i++){
            int[] row = md.getRow(i);
            int counter = 0;
            for(int j=0;j<row.length;j++){
                if(row[j] == number) counter++;
            }
            rs.data[i] = counter;
        }

        System.out.println(Thread.currentThread().getName()+" has finished searching");

        try{
            barrier.await();
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("BARRIER TRIPPED!");
    }
}

class Grouper implements Runnable{
    Results rs;


    Grouper(Results results){
        this.rs = results;
    }

    @Override
    public void run() {
        int counter=0;

        for(int item: rs.data){
            counter+=item;
        }

        System.out.println("Grouper Result :"+counter);
    }
}