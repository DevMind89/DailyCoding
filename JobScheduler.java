/*
 Good morning! Here's your coding interview problem for today.

This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
*/
public class JobScheduler {

	public static void main(String[] args) throws InterruptedException {
		int n = 5;
		
		while(true) {
			Thread.sleep(n);
			f();
		}
	}
	
	private static void f() {
		System.out.println("Function!");
	}	
}
