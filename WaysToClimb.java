/*
 Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. 
The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? 
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
import java.util.Scanner;

public class WaysToClimb {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Write numbers of steps: ");
		int steps = sc.nextInt();
		int ways = countWaysToClimb(steps);
		System.out.println("There are " + ways + " ways to climb " + steps + " steps");
		sc.close();
	}
	
	private static int countWaysToClimb(int steps) {
		
		if(steps <= 1 ) {
			return 1;
		}
		
		int[] ways = new int[steps + 1];
		ways[0] = 1;
		ways[1] = 1;
		
		for(int i = 2; i <= steps; i++) {
			ways[i] = ways[i - 1] + ways[i -2];
		}
		
		return ways[steps];
	}
}
