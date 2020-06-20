import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();
        int z = s.nextInt();

        Variables v1 = new Variables();

        calcSin s1 = new calcSin(x,v1);
        calcCos c1 = new calcCos(y,v1);
        calcTan t1 = new calcTan(z,v1);

        try{
            s1.start();
            c1.start();
            t1.start();

            s1.join();
            c1.join();
            t1.join();

        }catch(Exception e){

        }



        double ans = v1.ans1 + v1.ans2 + v1.ans3;


        System.out.println("Sin(x) + Cos(y) + Tan(z) :"+ans);
    }


}

class Variables{
    double ans1;
    double ans2;
    double ans3;

    Variables(){
        ans1 = 0;
        ans2 = 0;
        ans3 = 0;
    }
}

class calcSin extends Thread{

    int x;
    Variables cl1;

    calcSin(int num, Variables cl){
        this.x = num;
        this.cl1 = cl;
    }

    @Override
    public void run() {

        cl1.ans1 = Math.sin(x);
        System.out.println("This is Sin("+x+") Thread :"+cl1.ans1);
    }
}
class calcCos extends Thread{

    int x;
    Variables cl1;

    calcCos(int num, Variables cl){
        this.x = num;
        this.cl1 = cl;
    }

    @Override
    public void run() {
        cl1.ans2 = Math.cos(x);
        System.out.println("This is Cos("+x+") Thread :"+cl1.ans2);
    }
}
class calcTan extends Thread{

    int x;
    Variables cl1;

    calcTan(int num, Variables cl){
        this.x = num;
        this.cl1 = cl;
    }

    @Override
    public void run() {
        cl1.ans3 = Math.tan(x);
        System.out.println("This is Tan("+x+") Thread :"+cl1.ans3);
    }
}