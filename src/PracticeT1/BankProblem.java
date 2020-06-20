package PracticeT1;

import java.util.Random;

public class BankProblem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Random random = new Random();

        TxThreadDep[] depArr = new TxThreadDep[10];
        TxThreadWith[] withArr = new TxThreadWith[10];

        for(int i=0;i<10;i++){

            Thread t1 = new Thread(depArr[i] = new TxThreadDep(random.nextInt(100),bank));
            withArr[i] = new TxThreadWith(random.nextInt(100),bank);
            Thread t2 = new Thread(withArr[i]);

            t1.start();
            t2.start();
        }
    }

}

class Bank{
    int balance;
    boolean isEmpty;

    Bank(){
        this.balance = 0;
        this.isEmpty = true;
    }

    synchronized void deposit(int amount){
        this.balance += amount;
        System.out.println(amount+"$ deposited : Balance -->"+this.balance);

        if(this.balance>0) this.isEmpty = false;
    }

    synchronized void withdraw(int amount){

        if(this.isEmpty || this.balance - amount < 0){
            System.out.println(amount+"$ !! Can't Process TX !!: Balance -->"+this.balance);
            return;
        }

        balance -= amount;
        System.out.println(amount+"$ withdrawn : Balance -->"+this.balance);

        if(balance<=0) this.isEmpty = true;
    }
}

class TxThreadDep implements Runnable{

    int amount;
    Bank b;

    TxThreadDep(int amount, Bank bank){
        this.amount = amount;
        b = bank;
    }

    @Override
    public void run() {
        b.deposit(amount);
    }
}

class TxThreadWith implements Runnable{

    int amount;
    Bank b;

    TxThreadWith(int amount, Bank bank){
        this.amount = amount;
        b = bank;
    }

    @Override
    public void run() {
        b.withdraw(amount);
    }
}