package Tutorial3;

import java.util.*;

public class TutQuestion1 {

	public static void main(String[] args) {
		Resource re = new Resource();

		pushOperations[] p1 = new pushOperations[10];
		popOperations[] p2 = new popOperations[10];

		for(int i=0;i<10;i++) {
			Random num = new Random();
			int n = num.nextInt(100);

			p1[i] = new pushOperations(re,n);
			p2[i] = new popOperations(re);

			p1[i].start();
			p2[i].start();
		}

	}


}

class Resource {
	Stack<Integer> st;

	Resource(){
		st = new Stack<Integer>();
	}

	synchronized void pushInStack(int x) {
		System.out.println("Pushing using Thread :"+Thread.currentThread().getName());
		st.push(x);
		this.printStack();
		try {
			//wait();
			//Thread.sleep(1500);
		}catch(Exception e){

		}

	}

	synchronized void popFromStack() {
		System.out.println("Popping using Thread :"+Thread.currentThread().getName());
		if(st.isEmpty()) {
			System.out.println("STACK IS EMPTY!");
		}else {
			st.pop();
			this.printStack();
		}

		try {
			//notify();
			//Thread.sleep(1500);
		}catch(Exception e){

		}
	}

	synchronized void printStack() {
		if(st.empty()) return;

		int x = st.peek();
		st.pop();

		this.printStack();

		System.out.print(x + " ");

		st.push(x);
	}

}

class pushOperations extends Thread{
	Resource re;
	int x;

	pushOperations(Resource resource, int x){
		this.re = resource;
		this.x = x;
	}

	public void run() {
		re.pushInStack(x);
	}

}

class popOperations extends Thread{
	Resource re;

	popOperations(Resource resource){
		this.re = resource;
	}

	public void run() {
		re.popFromStack();
	}
}
