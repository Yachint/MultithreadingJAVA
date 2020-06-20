import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Tut4Ques4 {
    public static void main(String[] args) {
        MatrixData mat = new MatrixData(10000,1000,5);
        Results rs = new Results(10000);
        Grouper gp = new Grouper(rs);

        CyclicBarrier barrier = new CyclicBarrier(5,gp);

        Searcher[] sc = new Searcher[5];
        for(int i=0;i<5;i++){
            sc[i] = new Searcher(i*2000,(i*2000)+2000,5,mat,rs,barrier);
            sc[i].start();
        }
    }
}

class MatrixData{
    int[][] data;

    MatrixData(int rows, int columns, int number){
        int counter = 0;

        this.data = new int[rows][columns];
        Random random = new Random();

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                data[i][j] = random.nextInt(10);
                if(data[i][j] == number){
                    counter++;
                }
            }
        }

        System.out.println("OG COUNTER :"+counter);
    }

    int[] getRow(int row){
        if(row>=0 && row<data.length){
            return data[row];
        }
        return null;
    }
}

class Results{
    int[] data;

    public Results(int size){
        data = new int[size];
    }

}

class Searcher extends Thread{
    int firstRow, lastRow, number;
    MatrixData md;
    Results rs;
    CyclicBarrier barrier;

    Searcher(int fr, int lr, int num, MatrixData m, Results r, CyclicBarrier b){
        firstRow = fr;
        lastRow = lr;
        number = num;
        md = m;
        rs = r;
        barrier = b;
    }

    @Override
    public void run() {
        System.out.println("First Row :"+firstRow+" Last Row :"+lastRow);

        for(int i=firstRow;i<lastRow;i++){
            int row[] = md.getRow(i);
            int counter = 0;
            for(int j=0;j<row.length;j++){
                if(row[j]==number) counter++;
            }
            rs.data[i] = counter;
        }

        System.out.println(Thread.currentThread().getName()+"  FINISHED SEARCHING");

        try {
            barrier.await();
        }catch(Exception e){
            System.out.println("Error" + e);
        }
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