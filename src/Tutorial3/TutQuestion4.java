import java.util.Random;

public class TutQuestion4 {
    public static void main(String[] args) {
        Bank bInstance = new Bank();

        Depositer[] dp = new Depositer[10];
        Withdrawer[] wd = new Withdrawer[10];

        Random rand = new Random();

        for(int i=0;i<10;i++){
            dp[i] = new Depositer(bInstance,rand.nextInt(100));
            wd[i] = new Withdrawer(bInstance,rand.nextInt(100));

            dp[i].start();
            wd[i].start();
        }

    }
}

class Depositer extends Thread{

    Bank bankInstance;
    int amount;

    Depositer(Bank b, int x){
        this.bankInstance = b;
        this.amount = x;
    }


    public void run() {
        bankInstance.depositMoney(amount);
    }
}

class Withdrawer extends Thread{

    Bank bankInstance;
    int amount;

    Withdrawer(Bank b, int x){
        this.bankInstance = b;
        this.amount = x;
    }

    public void run(){
        bankInstance.withdrawMoney(amount);
    }
}

class Bank{
    int balance;
    boolean isEmpty;

    Bank(){
        this.balance = 0;
        this.isEmpty = true;
    }

    synchronized void depositMoney(int amount){
        try {
            balance += amount;
            System.out.println(amount+"$ deposited ---> CURRENT:"+balance+"$");
            if(balance > 0){
                this.isEmpty = false;
                notify();
            }
            Thread.sleep(500);

        }catch (Exception e){
            System.out.println("Error :"+e);
        }

    }

    synchronized void withdrawMoney(int amount){
        try{
            if(isEmpty == true){
                wait();
            }
            if(balance-amount <0){
                System.out.println(amount+"$ CANNOT BE WITHDRAWN, INSUFFICIENT BALANCE...");
                return;
            }
            balance -= amount;
            System.out.println(amount+"$ withdrawn ---> CURRENT:"+balance+"$");
            if(balance<=0) this.isEmpty = true;
            Thread.sleep(500);
            notify();
        }catch(Exception e){
            System.out.println("Error :"+e);

        }
    }
}
